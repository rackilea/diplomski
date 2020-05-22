class Person(private val service: Service) {

    private val record by lazy { service.doSomething() }

    fun name() = record.get("name");
}