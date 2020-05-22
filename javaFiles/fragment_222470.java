String json = "{\"invoices\":{\"createDate\":{\"operation\":\"betweenDate\",\"options\":[{\"name\":\"startDate\",\"value\":[\"06/01/2016\"]},{\"name\":\"endDate\",\"value\":[\"06/02/2016\"]}]}}}";

Client client = ClientBuilder.newClient();
WebTarget target = client.target("https://api.softlayer.com")
                         .path("rest")
                         .path("v3")
                         .path("SoftLayer_Account")
                         .path("getInvoices")
                         .queryParam("objectFilter", 
                             URLEncoder.encode(json, StandardCharsets.UTF_8.toString()));

String result = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);