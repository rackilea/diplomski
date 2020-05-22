@MXBean
public interface StatisticsMXBean extends Statistics {
}

public void initStatistics(SessionFactory sessionFactory) {
    ObjectName statsName = new ObjectName("org.hibernate:type=statistics");
    MBeanServer mbeanServer = ManagementFactory.getPlatformMBeanServer();

    final Statistics statistics = sessionFactory.getStatistics();
    statistics.setStatisticsEnabled(true);
    Object statisticsMBean = Proxy.newProxyInstance(getClass().getClassLoader(), new Class<?>[] { StatisticsMXBean.class }, new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(statistics, args);
            }
        });

    mbeanServer.registerMBean(statisticsMBean, statsName);
}