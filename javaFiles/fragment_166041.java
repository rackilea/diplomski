final GoogleCredentials googleCredentials = new GoogleCredentials(accessToken) {
        @Override
        public AccessToken refreshAccessToken() throws IOException {
            return accessToken;
        }
    }.createScoped(OAUTH2_SCOPES);