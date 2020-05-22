static <T> T createClient ( Class<T> t, String endpointAddress )
{
    JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
    factory.setServiceClass( t );
    factory.setAddress( endpointAddress );
    return (T) factory.create();
}

createClient( AccessibleClient.class, "...");