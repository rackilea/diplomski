package x
@SpringBootApplication
@groovy.util.logging.Slf4j
class DigSigServiceApplication {

    @Value('${digsig.trustweaver.truststore}') 
    String caTrustStore;

    static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(DigSigServiceApplication, args)
    }

    @Bean
    CommandLineRunner init() {
        log.info("caTrustStore = $caTrustStore")
    }
}