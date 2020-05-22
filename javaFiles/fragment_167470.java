Configuration cfg = new Configuration()
                .setProperty(Environment.URL,"jdbc:mysql://localhost/songkong")
                .setProperty(Environment.DRIVER,"com.mysql.jdbc.Driver")
                .setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.connection.username","dbuser")
                .setProperty("hibernate.connection.password", "dbpassword");;