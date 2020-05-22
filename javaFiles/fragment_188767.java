@Bean
public UdpSyslogReceivingChannelAdapter udpReceiver() {
    final UdpSyslogReceivingChannelAdapter adapter = new UdpSyslogReceivingChannelAdapter();
    adapter.setUdpAdapter(receiver());
    adapter.setOutputChannelName("routingChannel");
    adapter.setConverter(converter);
    return adapter;
}

@Bean
public UnicastReceivingChannelAdapter receiver() {
    UnicastReceivingChannelAdapter adapter = new UnicastReceivingChannelAdapter(properties.getUdp().getLocalPort());
    adapter.setTaskExecutor(executor());
    return adapter;
}

@Bean
public TaskExecutor executor() {
    ThreadPoolTaskExecutor exec = new ThreadPoolTaskExecutor();
    exec.setCorePoolSize(5);
    return exec;
}