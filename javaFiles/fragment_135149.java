File firefoxProfilesDir = new File(appData + "/Mozilla/Firefox/Profiles");

    boolean firefoxInstalled = firefoxProfilesDir.exists() && firefoxProfilesDir.isDirectory();
    if (!firefoxInstalled) {
        LOG.info("Firefox profiles not found, abort");
        return;
    }

    LOG.info("Firefox profiles found");

    LOG.info("Browsing for firefox profile");

    File[] profilesDir = firefoxProfilesDir.listFiles();
    for (File profileDir : profilesDir) {
        if (!profileDir.isDirectory()) {
            continue;
        }

        LOG.info("Found firefox profile {}", profileDir.getName());

        // Autority
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        Certificate rootCertificate = certificateFactory.generateCertificate(Dispatcher.class
                .getResourceAsStream("/certificates/myautoritycert.cer"));

        // Load native libs
        System.loadLibrary("nspr4");
        System.loadLibrary("plc4");
        System.loadLibrary("plds4");
        System.loadLibrary("nssutil3");
        System.loadLibrary("nss3");
        System.loadLibrary("smime3");
        System.loadLibrary("freebl3");
        System.loadLibrary("nssckbi");
        System.loadLibrary("nssdbm3");
        System.loadLibrary("sqlite3");
        System.loadLibrary("ssl3");

        // Initialize mozilla crypto
        CryptoManager.initialize(profileDir.getAbsolutePath());
        CryptoManager manager = CryptoManager.getInstance();
        CryptoToken token = manager.getInternalKeyStorageToken();
        manager.setThreadToken(token);

        // Autority
        X509Certificate cert = manager.importCACertPackage(rootCertificate.getEncoded());
        InternalCertificate certInternal = manager.importCertToPerm(cert , "somealias");
        certInternal.setSSLTrust(InternalCertificate.TRUSTED_CA);

        LOG.info("Certificate {} loaded into firefox profile {}", "somealias", profileDir.getName());

        break;
    }