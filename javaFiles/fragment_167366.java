private static CompletableFuture<ArrayList<Stock>> getAllAvailableStocks(String url) {
    CompletableFuture<ArrayList<Stock>> result = new CompletableFuture<>();
    Future<HttpResponse<JsonNode>> future = Unirest.get(url)
              .header("accept", "application/json")
              .asJsonAsync(new Callback<JsonNode>() {
                public void failed(UnirestException e) {
                    System.out.println("The request has failed");
                }

                public void completed(HttpResponse<JsonNode> response) {
                    System.out.println("The request succeeded");
                    ArrayList<Stock> stocks = new ArrayList<Stock>();
                    if (response != null && response.getStatus() == 200) {
                        JsonNode body = response.getBody();
                        // TODO Parse body and add items to `stocks`
                    }
                    result.complete(stocks);
                }

                public void cancelled() {
                    System.out.println("The request has been cancelled");
                }
            });

    return result;
}