PrivateKey privKey = null;

        StringBuilder pkcs8Lines = new StringBuilder();
        BufferedReader rdr = new BufferedReader(new StringReader(privatekey);


        String line;
        while ((line = rdr.readLine()) != null) {
            pkcs8Lines.append(line);
        }

        // Remove the "BEGIN" and "END" lines, as well as any whitespace

        String pkcs8Pem = pkcs8Lines.toString();
        pkcs8Pem = pkcs8Pem.replace("-----BEGIN PRIVATE KEY-----", "");
        pkcs8Pem = pkcs8Pem.replace("-----END PRIVATE KEY-----", "");
        pkcs8Pem = pkcs8Pem.replaceAll("\\s+", "");

        // Base64 decode the result

        byte[] pkcs8EncodedBytes = Base64.getDecoder().decode(pkcs8Pem);

        // extract the private key

        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(pkcs8EncodedBytes);
        KeyFactory kf;
        try {
            kf = KeyFactory.getInstance("RSA");
            try {
                privKey = kf.generatePrivate(keySpec);
            } catch (InvalidKeySpecException e) {
                throw new GenericException(e);
            }
        } catch (NoSuchAlgorithmException e) {
            throw new GenericException(e);
        }

        Credentials myCredentials = ServiceAccountCredentials.newBuilder().setProjectId(projectId)
                .setPrivateKeyId(privateKeyId).setPrivateKey(privKey)
                .setClientEmail(clientEmail).setClientId(clientId)
                .setTokenServerUri(URI.create(tokenServerUri)).build();

        SessionsSettings sessionsSettings = SessionsSettings.newBuilder()
                .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials)).build();

        try (SessionsClient sessionsClient = SessionsClient.create(sessionsSettings)) {