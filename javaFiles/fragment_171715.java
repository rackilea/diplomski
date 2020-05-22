final CompletionStage<WSResponse> futureResponse = this.playWS.client
        .url(importSource.getDownloadUrl())
        .setMethod(HttpMethod.GET)
        .setRequestTimeout(Duration.ofSeconds(5)) 
        .stream();

Source<WSResponse> source = Source.fromCompletableStage(futureResponse);
source.map(...).filter(...).recover(...).runforeach(..., playWS.materializer)