public static void main(String... args) throws IOException, InterruptedException, ExecutionException {
    Future<HttpResponse<String>> asyncCall = Unirest.get("http://thecatapi.com/api/images/get?format=xml&results_per_page=20").asStringAsync(new Callback<String>() {
        @Override
        public void completed(HttpResponse<String> response) {
            System.out.println(response.getStatusText());
        }

        @Override
        public void failed(UnirestException e) {
            System.out.println("failed");
        }

        @Override
        public void cancelled() {
            System.out.println("cancelled");
        }
    });
    HttpResponse<String> httpResponse = asyncCall.get(); // Can also use Future.isDone(), etc
    // System.out.println(httpResponse.getBody());
    Unirest.shutdown();
}