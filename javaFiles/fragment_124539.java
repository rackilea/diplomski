IntegrationFlow flow = IntegrationFlows.from(Ftp.inboundAdapter(sessionFactory())
                .preserveTimestamp(true)
                .remoteDirectory("ftpSource")
                .regexFilter(".*\\.txt$")
                .localFilename(f -> f.toUpperCase() + ".a")
                .localDirectory(getTargetLocalDirectory()),
        e -> e.id("ftpInboundAdapter")
              .poller(Pollers.fixedDelay(100)
                    .transactionSynchronizationFactory(syncFactory())))
        .channel(out)
        .get();