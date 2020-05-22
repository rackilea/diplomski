AtomicInteger numCompleted = new AtomicInteger();

Future <HttpResponse<JsonNode>> future1 = Unirest.get("https://example.com/api").asJsonAsync(new Callback<JsonNode>() {
  public void completed(HttpResponse<JsonNode> response) {
    responses.put(response);
    int numDone = numCompleted.incrementAndGet();
    if (numDone == 2) {
      doStuff(responses);
    }
  }
});