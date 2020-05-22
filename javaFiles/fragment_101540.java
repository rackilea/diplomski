class ApiCaller {
    private WebClient webClient;

    ApiCaller(WebClient webClient) {
         this.webClient = webClient;
    }

    Mono<SimpleResponseDto> callApi() {
         return webClient.put()
             .uri("/api/resource")
             .contentType(MediaType.APPLICATION_JSON)
             .header("Authorization", "customAuth")
             .syncBody(new SimpleRequestDto())
             .retrieve()
             .bodyToMono(SimpleResponseDto.class);
    }
}