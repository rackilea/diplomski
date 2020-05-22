// Load input stream into keystore
    keystore.load(is, password.toCharArray());

    // List the aliases
    Enumeration aliases = keystore.aliases();
    for (; aliases.hasMoreElements(); ) {
        String alias = (String)aliases.nextElement();

        // Does alias refer to a private key?
        boolean b = keystore.isKeyEntry(alias);

        // Does alias refer to a trusted certificate?
        b = keystore.isCertificateEntry(alias);
    }