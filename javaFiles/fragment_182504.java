@RibbonClients(defaultConfiguration=MyConfig.class)

//...

class MyConfig {
    @Bean
    public ServerList<Server> ribbonServerList() {
        return new MyCustomServerList();
    }
}