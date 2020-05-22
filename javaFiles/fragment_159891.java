XMPPTCPConnectionConfiguration.Builder configBuilder = XMPPTCPConnectionConfiguration.builder();
        configBuilder.setUsernameAndPassword(params[0], params[1]);
        configBuilder.setServiceName("Openfire");
        configBuilder.setHost(Host);
        configBuilder.setPort(port);
        configBuilder.build();