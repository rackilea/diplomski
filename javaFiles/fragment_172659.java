ClientConfig config = new DefaultClientConfig();
Client client = Client.create(config);
Unidade u = new Unidade();
u.setUnidSigla("KG");
WebResource webResource = client.resource("http://localhost:8080/RestauranteWeb/rest/unidades/7");
Unidade response = webResource.accept(MediaType.APPLICATION_JSON)
                          .type(MediaType.APPLICATION_JSON)
                           .post(Unidade.class, u);