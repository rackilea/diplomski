@Bean
public EbeanServerFactoryBean ebeanServerFactoryBean() {
    EbeanServerFactoryBean ebeanServerFactoryBean = new EbeanServerFactoryBean();
    ServerConfig config = new ServerConfig();

    config.setName("pg");
    config.loadFromProperties();
    //other configs
    config.setDefaultServer(true);

    ebeanServerFactoryBean.setServerConfig(config);
    return ebeanServerFactoryBean;
}