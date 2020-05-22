public static void main(String[] args) {
    SpringApplication.run(DigitalTheaterApplication.class, args);
}

@Bean
public CommandLineRunner tester(SampleService service) {
    return args -> service.sample();
}