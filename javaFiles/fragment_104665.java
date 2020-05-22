if (mbs.isRegistered(name)) {
        PerfMonitorMBean mbean =
           (PerfMonitorMBean)MBeanServerInvocationHandler.newProxyInstance(
                mbs,name,PerfMonitorMBean.class,true);
        perfMonHash.put(beanName, mbean);
        return;
}