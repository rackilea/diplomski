@Bean
public ProtocolSocketFactory socketFactory() {
    return new TLSProtocolSocketFactory();
}

@Bean
public Protocol socketFactoryProtocol() {
    return new Protocol("https", socketFactory(), 443);
}

@Bean
public MethodInvokingFactoryBean socketFactoryInitialization() {
    MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
    methodInvokingFactoryBean.setTargetClass(Protocol.class);
    methodInvokingFactoryBean.setTargetMethod("registerProtocol");
    Object[] args = {"https", socketFactoryProtocol()};
    methodInvokingFactoryBean.setArguments(args);
    return methodInvokingFactoryBean;
}

@Bean
@Qualifier("metadata")
@DependsOn("socketFactoryInitialization")
public CachingMetadataManager metadata() throws MetadataProviderException, IOException     {
  ...
}