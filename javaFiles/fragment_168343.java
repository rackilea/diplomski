public void write() {
    ArrayList<Person> personList = new ArrayList<>();

    Person p1 = new Person("James", "Bond", LocalDate.of(1997, 9, 22));
    Person p2 = new Person("Santa", "Claus", LocalDate.of(1918, 11, 6));
    Person p3 = new Person("Peter", "Griffin", LocalDate.of(1978, 3, 24));
    Person p4 = new Person("Lois", "Griffin", LocalDate.of(1982, 7, 14));

    personList.add(p1);
    personList.add(p2);
    personList.add(p3);
    personList.add(p4);

    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

    try {
        writer.writeValue(new File("./person.json"), personList);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public void read() {
    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    try {
        ArrayList<Person> list = mapper.readValue(new FileInputStream("./person.json"),
                mapper.getTypeFactory().constructCollectionType(ArrayList.class, Person.class));
        System.out.println("Read: " + list.get(0).getFirstname());
    } catch (IOException e) {
        e.printStackTrace();
    }

}