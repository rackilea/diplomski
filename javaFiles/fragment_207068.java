package org.helios.jboss.jmx.mxbean;

public class MXBeanPublisher extends ServiceMBeanSupport implements MXBeanPublisherMBean {
    protected final Map<ObjectName, DynamicMBeanNotifEnabled> published = new HashMap<ObjectName, DynamicMBeanNotifEnabled>();
    protected final ExecutorService executor = Executors.newCachedThreadPool();
    public Set<ObjectName> getPublishedNames() {
        return Collections.unmodifiableSet(published.keySet());
    }
    public static interface DynamicMBeanNotifEnabled extends NotificationBroadcaster, NotificationEmitter, DynamicMBean, NotificationListener {

        public void startNotifications() throws InstanceNotFoundException;
        public void stopNotifications() throws InstanceNotFoundException, ListenerNotFoundException;
    }


    protected DynamicMBeanNotifEnabled publishMXBean(final ObjectName on, Class<?> iface) throws InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException, InstanceNotFoundException {
        final MBeanServer platformAgent = ManagementFactory.getPlatformMBeanServer();
        DynamicMBeanNotifEnabled dmb = new DynamicMBeanNotifEnabled() {
            NotificationBroadcasterSupport bcaster = new NotificationBroadcasterSupport(executor);
            public Object getAttribute(String attribute)throws AttributeNotFoundException, MBeanException, ReflectionException {
                try {
                    return platformAgent.getAttribute(on, attribute);
                } catch (InstanceNotFoundException e) {
                    throw new MBeanException(e, "Instance [" + on + "] not found");
                }
            }
            public void setAttribute(Attribute attribute)throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
                try {
                    platformAgent.setAttribute(on, attribute);
                } catch (InstanceNotFoundException e) {
                    throw new MBeanException(e, "Instance [" + on + "] not found");
                }               
            }
            public AttributeList getAttributes(String[] attributes) {
                try {
                    return platformAgent.getAttributes(on, attributes);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to getAttributes on [" + on + "]", e);
                }               
            }
            public AttributeList setAttributes(AttributeList attributes) {
                try {
                    return platformAgent.setAttributes(on, attributes);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to setAttributes on [" + on + "]", e);
                }                               
            }
            public Object invoke(String actionName, Object[] params,String[] signature) throws MBeanException, ReflectionException {
                try {
                    return platformAgent.invoke(on, actionName, params, signature);
                } catch (InstanceNotFoundException e) {
                    throw new MBeanException(e, "Instance [" + on + "] not found");
                }                                   
            }
            public MBeanInfo getMBeanInfo() {
                try {
                    return platformAgent.getMBeanInfo(on);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to get MBeanInfo for Instance [" + on + "]", e);
                }                                               
            }
            public void addNotificationListener(NotificationListener listener,
                    NotificationFilter filter, Object handback) {
                bcaster.addNotificationListener(listener, filter, handback);
            }
            public void removeNotificationListener(NotificationListener listener)
                    throws ListenerNotFoundException {
                bcaster.removeNotificationListener(listener);
            }
            public void removeNotificationListener(
                    NotificationListener listener, NotificationFilter filter,
                    Object handback) throws ListenerNotFoundException {
                bcaster.removeNotificationListener(listener, filter, handback);
            }
            public MBeanNotificationInfo[] getNotificationInfo() {
                return bcaster.getNotificationInfo();
            }

            public void startNotifications() throws InstanceNotFoundException {
                ManagementFactory.getPlatformMBeanServer().addNotificationListener(on, this, null, null);
            }
            public void stopNotifications() throws InstanceNotFoundException, ListenerNotFoundException {
                ManagementFactory.getPlatformMBeanServer().removeNotificationListener(on, this, null, null);
            }

            @Override
            public void handleNotification(Notification notification, Object handback) {
                bcaster.sendNotification(notification);
            }
        }; 
        if(server.isRegistered(on)) return null;
        server.registerMBean(dmb, on);
        published.put(on, dmb);
        dmb.startNotifications();
        return dmb;
    }

    public void startService() throws Exception {
        try { publishMXBean(new ObjectName(ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME), OperatingSystemMXBean.class); } catch (Exception e) {
            log.error("Failed to publish OperatingSystemMXBean", e);
        };
        try { publishMXBean(new ObjectName(ManagementFactory.CLASS_LOADING_MXBEAN_NAME), ClassLoadingMXBean.class); } catch (Exception e) {
            log.error("Failed to publish ClassLoadingMXBean", e);
        };
        try { publishMXBean(new ObjectName(ManagementFactory.MEMORY_MXBEAN_NAME), MemoryMXBean.class); } catch (Exception e) {
            log.error("Failed to publish MemoryMXBean", e);
        };
        try { publishMXBean(new ObjectName(ManagementFactory.RUNTIME_MXBEAN_NAME), RuntimeMXBean.class); } catch (Exception e) {
            log.error("Failed to publish RuntimeMXBean", e);
        };
        try { publishMXBean(new ObjectName(ManagementFactory.THREAD_MXBEAN_NAME), ThreadMXBean.class); } catch (Exception e) {
            log.error("Failed to publish RuntimeMXBean", e);
        };
        for(GarbageCollectorMXBean gc: ManagementFactory.getGarbageCollectorMXBeans()) {
            try { publishMXBean(new ObjectName(ManagementFactory.GARBAGE_COLLECTOR_MXBEAN_DOMAIN_TYPE + ",name=" + gc.getName()), GarbageCollectorMXBean.class); } catch (Exception e) {
                log.error("Failed to publish GarbageCollectorMXBean[" + gc.getName() + "]", e);
            };          
        }
        for(MemoryManagerMXBean mm: ManagementFactory.getMemoryManagerMXBeans()) {
            try { publishMXBean(new ObjectName(ManagementFactory.MEMORY_MANAGER_MXBEAN_DOMAIN_TYPE + ",name=" + mm.getName()), MemoryManagerMXBean.class); } catch (Exception e) {
            };          
        }
        for(MemoryPoolMXBean mp: ManagementFactory.getMemoryPoolMXBeans()) {
            try { publishMXBean(new ObjectName(ManagementFactory.MEMORY_POOL_MXBEAN_DOMAIN_TYPE + ",name=" + mp.getName()), MemoryPoolMXBean.class); } catch (Exception e) {
                log.error("Failed to publish MemoryPoolMXBean[" + mp.getName() + "]", e);
            };          
        }
    }

    public void stopService() {
        for(Map.Entry<ObjectName, DynamicMBeanNotifEnabled> entry: published.entrySet()) {
            try { server.unregisterMBean(entry.getKey()); } catch (Exception e) {}
            try { entry.getValue().stopNotifications(); } catch (Exception e) {}
        }
        published.clear();
    }
}