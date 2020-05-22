private void getAccessToken(HttpServletResponse response, final HttpSession session, final String code)
    {
        HttpClient httpClient = new HttpClient();
        PostMethod accessTokenRequest = new PostMethod(accessTokenEndpoint);
        AccessToken var8;
        try {
            accessTokenRequest.addRequestHeader(new Header("Authorization", "Basic " + "http://localhost:8080/oauth/token"));
            accessTokenRequest.addRequestHeader(new Header("Accept", "application/json"));
            NameValuePair[] params = new NameValuePair[] { new NameValuePair("code", code),
                    new NameValuePair("grant_type", "authorization_code"),
                    new NameValuePair("redirect_uri", " your redirect uri"), new NameValuePair("client_id", "your client id") };
            accessTokenRequest.setQueryString(EncodingUtil.formUrlEncode(params, UTF_8.displayName()));
            httpClient.executeMethod(accessTokenRequest);
            if (accessTokenRequest.getStatusCode() != 200) {
                this.toException(accessTokenRequest);
                return null;
            }

            // JSON response Object AccessToken
            AccessToken accessToken = (AccessToken) PARSER.readValue(accessTokenRequest.getResponseBodyAsStream(),
                    AccessToken.class);
            final PrintWriter writer = response.getWriter();
            writer.append(accessToken.getTokenString);
            writer.flush();
        } catch (IOException e) {
            log.error("IO Exception : {}", e.getMessage());
        }

        finally {
            accessTokenRequest.releaseConnection();
        }
    }