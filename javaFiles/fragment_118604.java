JiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
    HttpClientOptions options = new HttpClientOptions();
    options.setTrustSelfSignedCertificates(true);
    DefaultHttpClientFactory defaultHttpClientFactory = new DefaultHttpClientFactory(new NoOpEventPublisher(),
            new RestClientApplicationProperties(JIRA_URI), new ThreadLocalContextManager() {
        @Override
        public Object getThreadLocalContext() {
            return null;
        }

        @Override
        public void setThreadLocalContext(Object context) {
        }

        @Override
        public void clearThreadLocalContext() {
        }
    });
    HttpClient httpClient = defaultHttpClientFactory.create(options);

    AtlassianHttpClientDecorator atlassianHttpClientDecorator = new AtlassianHttpClientDecorator(httpClient, new BasicHttpAuthenticationHandler(userName, password)) {
        @Override
        public void destroy() throws Exception {
            defaultHttpClientFactory.dispose(httpClient);
        }
    };
    JiraRestClient client = factory.create(JIRA_URI, atlassianHttpClientDecorator);