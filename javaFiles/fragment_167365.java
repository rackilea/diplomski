private static ArrayList<Stock> getAllAvailableStocks(String url) {
    ArrayList<Stock> stocks = new ArrayList<Stock>();
    Future<HttpResponse<JsonNode>> future = Unirest.get(url)
              .header("accept", "application/json")
              .asJsonAsync(new Callback<JsonNode>() {
                public void failed(UnirestException e) {
                    System.out.println("The request has failed");
                }

                public void completed(HttpResponse<JsonNode> response) {
                    System.out.println("The request succeeded");
                }

                public void cancelled() {
                    System.out.println("The request has been cancelled");
                }
            });

    HttpResponse<JsonNode> response = future.get(); // NOTE: This call is blocking until the request is finished
    if (response != null && response.getStatus() == 200) {
        JsonNode body = response.getBody();
        // TODO Parse body and add items to `stocks`
    }
    return stocks;
}