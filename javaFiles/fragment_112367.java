@Bean(initMethod = "start", destroyMethod = "stop")
@Autowired
public ServerSession serverSession(MyRepo repo) throws Exception {
    repo.loadSomeValues();
    ServerSession serverSession = new ServerSession(urlGateway, useSsl, hostGateway, portGateway);
    return serverSession;
}