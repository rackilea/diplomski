SessionFactory sessionFactory;

public void init() {
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    try {
        Properties properties = new Properties();
        tx = session.beginTransaction();
        List<ConfigurationProperty> dbProperties = session.createCriteria(ConfigurationProperty.class).list();
        for (ConfigurationProperty property : dbProperties) {
            properties.setProperty(property.getPropertyKey(), property.getPropertyValue());
        }
        setProperties(properties);
        tx.commit();
    } finally {
        session.close();
    }
}