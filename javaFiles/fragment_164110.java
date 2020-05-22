public class LoginJsonAuthConverter implements Function<ServerWebExchange, Mono<Authentication>> {

    private final ObjectMapper mapper;

    @Override
    public Mono<Authentication> apply(ServerWebExchange exchange) {
        return exchange.getRequest().getBody()
                .next()
                .flatMap(buffer -> {
                    try {
                        SignInRequest request = mapper.readValue(buffer.asInputStream(), SignInRequest.class);
                        return Mono.just(request);
                    } catch (IOException e) {
                        log.debug("Can't read login request from JSON");
                        return Mono.error(e);
                    }
                })
                .map(request -> new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
    }
}