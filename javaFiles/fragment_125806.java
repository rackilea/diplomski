@Bean(initMethod = "migrate")
public Flyway flyway() {
    Flyway flyway = new Flyway();
    // configure bean here
    return flyway;
}