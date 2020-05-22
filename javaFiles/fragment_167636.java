Configuration configuration = new Configuration();
configuration.configure();

configuration.setProperty("hibernate.connection.url", dbUrl);
configuration.setProperty("hibernate.connection.username", dbUser);
configuration.setProperty("hibernate.connection.password", dbPassword); 

return configuration.buildSessionFactory();