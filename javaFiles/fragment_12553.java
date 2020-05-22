GSSManager manager = GSSManager.getInstance();
    GSSName clientName = manager.createName("clientUser", GSSName.NT_USER_NAME);
    GSSCredential clientCred = manager.createCredential(clientName,
                                                        8 * 3600,
                                                        createKerberosOid(),
                                                        GSSCredential.INITIATE_ONLY);

    GSSName serverName = manager.createName("http@server", GSSName.NT_HOSTBASED_SERVICE);

    GSSContext context = manager.createContext(serverName,
                                               createKerberosOid(),
                                               clientCred,
                                               GSSContext.DEFAULT_LIFETIME);
    context.requestMutualAuth(true);
    context.requestConf(false);
    context.requestInteg(true);

    byte[] outToken = context.initSecContext(new byte[0], 0, 0);
    System.out.println(new BASE64Encoder().encode(outToken));
    context.dispose();