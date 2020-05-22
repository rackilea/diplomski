@Component
class AuthorizationFilter : WebFilter {
    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        val mutatedRequest = exchange.request.mutate().header(HttpHeaders.AUTHORIZATION, "Bearer $authHeader").build()
        val mutatedExchange = exchange.mutate().request(mutatedRequest).build()
        return chain.filter(mutatedExchange)
    }
}