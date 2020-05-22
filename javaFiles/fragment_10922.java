ClientHttpResponse response = restTemplate.execute(
            "http://localhost:8080/messenger-webapp/login",
            HttpMethod.POST,
            new RequestCallback() {

                @Override
                public void doWithRequest(ClientHttpRequest request) throws IOException {
                    request.getBody().write(("username=" + user + "&password=" + pw).getBytes());
                }
            },
            new ResponseExtractor<ClientHttpResponse>() {

                @Override
                public ClientHttpResponse extractData(ClientHttpResponse response)
                        throws IOException {
                    return response;
                }
            });