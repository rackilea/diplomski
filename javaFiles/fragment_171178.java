public Mono<MyObject> getOneObject(String endpoint) {
    return webClient.get()
        .uri(endpoint)
        .retrieve()
        .bodyToMono(MyObject.class)
}