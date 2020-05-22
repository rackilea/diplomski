public class ResteasyClientFactoryBean implements FactoryBean<ResteasyClient>{

    private int connectionTimeout;
    private int socketTimeout;


    public ResteasyClient getObject() throws Exception {
        return new ResteasyClientBuilder()
                    .establishConnectionTimeout(connectionTimeout, TimeUnit.SECONDS)
                    .socketTimeout(socketTimeout, TimeUnit.SECONDS)
                    .build();;
    }

    public Class<? extends ResteasyClient> getObjectType() {
        return ResteasyClient.class;
    }

    public boolean isSingleton() {
        return true;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }
}