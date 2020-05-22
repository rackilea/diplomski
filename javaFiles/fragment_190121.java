@Configuration
class Config {
    @Primary @Bean
    ObjectMapper primary() {...}

    @Bean
    ObjectMapper qualified(){...}

    @Bean
    ObjectMapper resulted(ObjectMapper primary, 
                         @Autowired(required = false)  @Qualifier("qualified") ObjectMapper qualified){
       return qualified == null ? primary : qualified;
    }
}