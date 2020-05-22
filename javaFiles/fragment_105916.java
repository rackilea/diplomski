@Bean
public RestTemplate rest(final RestTemplateBuilder builder) {
    return builder
             .setConnectTimeout(50000)
             .setReadTimeout(50000)
             .build()
}