@Value("${serverName}")
private String serverName;

@Bean
public ServerSingleton serverSingleton() {
    ServerSingleton instance = ServerSingleton.INSTANCE;
    instance.setServerName(serverName);
    return instance;
}