public static void main(String[] argv) {
    var client = HttpClient.newBuilder().build();
    var request = HttpRequest.newBuilder()
            .uri(URI.create("http://www.example.com/"))
            .build();
    var cf = client.sendAsync(request, HttpResponse.BodyHandlers.discarding())
            .thenApplyAsync((resp) -> {
                int status = resp.statusCode();
                if (status != 200) {
                    System.err.println("Error: " + resp.statusCode());
                } else {
                    System.out.println("Success: " + resp.statusCode());
                }
                return resp;
            });
    cf.join(); // prevents main() from exiting too early
}