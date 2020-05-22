private static javax.persistence.EntityManagerFactory getEntityManagerFactory() {
    if (emf == null) {
        Map properties = new HashMap();
        properties.put("hibernate.connection.url", "jdbc:hsqldb:file:" +
                ConfigurationUtil.CONFIG_DIRECTORY + File.separator +
                "local.db");
        emf = Persistence.createEntityManagerFactory("FPU", properties);
    }
    return emf;
}