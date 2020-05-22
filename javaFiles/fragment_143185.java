HttpRequest request = HttpRequest.POST("/categories", category);
client.toBlocking().exchange(request, Argument.of(Object.class), Argument.of(JsonError));

...

exception.getResponse().getBody(Argument.of(Response.class, Category.class)) // This return an Optional