ActiveMQSslConnectionFactory connectionFactory = new ActiveMQSslConnectionFactory(url);
            try {
                connectionFactory.setTrustStore(CLIENT_TS_FILE);
                connectionFactory.setTrustStorePassword("PASSWORD asked while TS file made");
                connectionFactory.setKeyStore(CLIENT_KS_FILE);
                connectionFactory.setKeyStorePassword("PASSWORD asked while KS file made");
            } catch (Exception e) {
                throw new MotorException(
                        "JMS Connection Failed (Trust store or key store weren't found) : ",
                        e);
            }