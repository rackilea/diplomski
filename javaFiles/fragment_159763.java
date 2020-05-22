private static ExchangeService getService() throws Exception {
    ExchangeService service = new ExchangeService(ExchangeVersion.Exchange2010);
    ExchangeCredentials credentials = new WebCredentials("USERNAME","PASS");
    service.setCredentials(credentials);
    service.setUrl(new URI("DOMAIN"));
    return service;
}