CountDownLatch responseWaiter = new CountDownLatch(2);

Future <HttpResponse<JsonNode>> future1 = Unirest.get("https://example.com/api").asJsonAsync(new Callback<JsonNode>() {
  public void completed(HttpResponse<JsonNode> response) {
    responses.put(response);
    responseWaiter.countDown();
  }
  ...
});

// Similar code for the other get call
...

responseWaiter.await();
doStuff(responses);