@JacksonXmlRootElement(localName = "person")
static class Person {
    @JacksonXmlProperty(isAttribute = true)
    final int age;

    @JacksonXmlProperty(isAttribute = true)
    final String name;

    @JacksonXmlProperty(isAttribute = true)
    final LocalDate dateOfBirth;

    @ConstructorProperties({"age", "name", "dateOfBirth"})
    public Person(int age, String name, LocalDate dateOfBirth) {
        this.age = age;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    //...