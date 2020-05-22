return new NetClientOptions()
            .setSsl(true)
            .addEnabledSecureTransportProtocol("TLSv1.2")
            .setPfxKeyCertOptions(
                    new PfxOptions()
                            .setPath(pathToKeystoreFile)
                            .setPassword(keystorePassword)
            )
            .setPemTrustOptions(
                    new PemTrustOptions()
                            .addCertPath(rootCACertificate)
            );