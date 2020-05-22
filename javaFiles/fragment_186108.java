Configuration configuration = new Configuration().configure();

...
...
configuration.setProperty("hibernate.connection.url", getAMSValue("url"));
configuration.setProperty("hibernate.connection.username", getAMSValue("username"));
configuration.setProperty("hibernate.connection.password", getAMSValue("password"));