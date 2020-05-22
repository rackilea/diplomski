@PostConstruct
public void init() {
    ConsoleReporter.enable(10, TimeUnit.SECONDS);    
} 

@Timed
public void doService(...) {
    .... do stuff ....
}