XMPPTCPConnectionConfiguration.Builder configBuilder;
    configBuilder = XMPPTCPConnectionConfiguration.builder();
    configBuilder.setUsernameAndPassword(username, password);
    try {
        configBuilder.setXmppDomain(OpenFireApiInteractor.XMPP_DOMAIN);

        configBuilder.setHost(ipAddress);
        connection = new XMPPTCPConnection(configBuilder.build());
        connection.addConnectionListener(this);

    } catch (XmppStringprepException e) {
        e.printStackTrace();
    }