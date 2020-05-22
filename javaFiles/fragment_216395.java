RequestBuilder requestBuilder = new RequestBuilder(
    RequestBuilder.GET, FOOBAR_SERVICE_URL);

Request request = requestBuilder.sendRequest("",
   new RequestCallback<ResultList>() { .... });

...

//user clicked cancel button
request.cancel();