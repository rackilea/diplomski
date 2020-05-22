if (mbs.isRegistered(name)) {
        PerfMonitorMBean mbean =null;
        port=System.getProperty("com.sun.management.jmxremote.port");
            JMXServiceURL url =
                    new JMXServiceURL("service:jmx:rmi:///jndi/rmi://:"+port+"/jmxrmi");
                JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
                MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
                mbean = JMX.newMBeanProxy(mbsc, name, PerfMonitorMBean.class, true);


        perfMonHash.put(beanName, mbean);

        return;

        }