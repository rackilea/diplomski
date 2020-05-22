bookResponseMono = webClient.get()
    .uri("/getBooking/" + bookingId)
    .headers(headers->headers.addAll(args))
    .retrieve()
    .bodyToMono(String.class)
    .onErrorResume(err -> {
        BookResponse bookResponse = new BookResponse();
        bookResponse.setError(setError(err));
        return Mono.just(setError(err));
    });

addressResponseMono = webClient.get()
    .uri("/getAddress/" + bookingId)
    .headers(headers -> headers.addAll(args))
    .retrieve()
    .bodyToMono(String.class)
    .onErrorResume(err -> {
        Address address = new Address();
        address.setError(setError(err));
        return Mono.just(setError(err));
    });