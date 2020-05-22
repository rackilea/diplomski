CloseableHttpClient httpClient = HttpClientBuilder
        .create()
        .setRedirectStrategy( new DefaultRedirectStrategy() {

            @Override
            public boolean isRedirected(HttpRequest request, HttpResponse response,
                    HttpContext context) throws ProtocolException {

                System.out.println(response);

                // If redirect intercept intermediate response.
                if (super.isRedirected(request, response, context)){
                    int statusCode  = response.getStatusLine().getStatusCode();
                    String redirectURL = response.getFirstHeader("Location").getValue();
                    System.out.println("redirectURL: " + redirectURL);
                    return true;
                }
                return false;
            }
        })
        .build();
HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
RestTemplate restTemplate = new RestTemplate(factory);
.......