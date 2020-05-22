Http http = Http.get(context().system());
ActorMaterializer materializer = ActorMaterializer.create(context().system());
Flow<HttpRequest, HttpResponse, CompletionStage<OutgoingConnection>> flow = http.outgoingConnection(ConnectHttp.toHost("localhost", 8091));
HttpRequest request = HttpRequest.POST("http://localhost:8091").withEntity(ContentTypes.APPLICATION_JSON, message);

Source.single(request).via(flow).runWith(Sink.head(), materializer).whenComplete((r, t) -> log.info("httpResponse: {}, throwable: {}", r, t));