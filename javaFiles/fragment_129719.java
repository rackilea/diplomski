FtpServerFactory serverFactory = new FtpServerFactory();

ConnectionConfigFactory connectionConfigFactory = new ConnectionConfigFactory();
connectionConfigFactory.setAnonymousLoginEnabled(false);

serverFactory.setConnectionConfig(connectionConfigFactory.createConnectionConfig());
serverFactory.setUserManager(new TestUserManagerFactory().createUserManager());

startFtpServer(serverFactory);