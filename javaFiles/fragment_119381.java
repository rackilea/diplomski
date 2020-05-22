private static SessionFactory buildSessionFactory() {

        try {
            Configuration configuration = new Configuration();
            Properties properties = extractPropertiesFile();

            configuration.configure("hibernate.cfg.xml").setProperties(properties);

            // The properties below are extracted from $TOMCAT_HOME/lib/myapp.properties
            configuration.setProperty("hibernate.connection.driver_class", properties.getProperty("propertyfile.database.driver.classname"));
            serviceRegistry = new ServiceRegistryBuilder().applySettings(
                    configuration.getProperties()). buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (HibernateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }