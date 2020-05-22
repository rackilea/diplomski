GoogleCredential credential = new GoogleCredential.Builder()
    .setJsonFactory(JSON_FACTORY).setTransport(TRANSPORT)
    .setClientSecrets(CLIENT_ID, CLIENT_SECRET).build();
GoogleTokenResponse tokenFromExchange = exchangeCode(accessToken);
credential.setFromTokenResponse(tokenFromExchange);
Plus plus = new Plus.Builder(TRANSPORT, JSON_FACTORY, credential).build();