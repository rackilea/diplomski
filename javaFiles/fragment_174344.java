ObjectName gcName = new ObjectName(ManagementFactory.GARBAGE_COLLECTOR_MXBEAN_DOMAIN_TYPE + ",*");

for (ObjectName name : mbs.queryNames(gcName, null)) {
    GarbageCollectorMXBean gc = ManagementFactory.newPlatformMXBeanProxy(mbs, name.getCanonicalName(), GarbageCollectorMXBean.class);            
    System.out.println(gc.getName());            
}