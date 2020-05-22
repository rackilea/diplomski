@Bean(initMethod = "migrate")
def flyway() = {
    val fly = new Flyway()
    fly.setDataSource(dataSource)
    fly
}