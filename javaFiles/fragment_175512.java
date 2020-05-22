........
.unmarshal().json(JsonLibrary.Jackson, RestResponse.class)
.process(exchange -> {

              RestResponse response = exchange.getIn().getBody(RestResponse.class);
               // Do your logic here.

  })