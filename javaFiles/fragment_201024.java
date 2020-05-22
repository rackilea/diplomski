OAuthRequest r = new OAuthRequest(Verb.POST, url);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        toSend.writeTo(out);
        r.addPayload(out.toByteArray());
        r.addHeader(toSend.getContentType().getName(), toSend.getContentType().getValue());

        OAuth10aServiceImpl oauth = (OAuth10aServiceImpl)client._oauth;
        OAuthRequest sr = new OAuthRequest(Verb.GET, serviceProvider);
        oauth.signRequest(client._oauthToken, sr);

        r.addHeader("X-Auth-Service-Provider",serviceProvider);
        String oauthHeader = sr.getHeaders().get("Authorization");
        r.addHeader("X-Verify-Credentials-Authorization", oauthHeader);