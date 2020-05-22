FtpInboundFileSynchronizingMessageSource ftpSource =
            Ftp.inboundAdapter(sessionFactory())
                    .regexFilter(".*\\.txt$")
                    .get();
    ftpSource.setScanner(...);
    IntegrationFlow flow = IntegrationFlows.from(ftpSource,