@Bean
fun restTemplate(restTemplateBuilder: RestTemplateBuilder,
                     responseErrorHandler: ResponseErrorHandler): RestTemplate {
        return restTemplateBuilder
                .errorHandler(responseErrorHandler)
                .build()
}