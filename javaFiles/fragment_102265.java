ClientConfig clientConfig = new DefaultClientConfig();
clientConfig.getClasses().add(JacksonJsonProvider.class);
Client client = Client.create(clientConfig);

return client
    .resource(Constants.BASE_URL)
    .path(Constants.CATEGORIES_ANIMALS)
    .type(MediaType.APPLICATION_JSON)
    .accept(MediaType.APPLICATION_JSON)
    .cookie(cookie)
    .get(new GenericType<List<AnimalCategoryResponse>>(){});