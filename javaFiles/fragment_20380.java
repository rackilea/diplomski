Person person = new Person("Bob",new LocalDate(1900,02,22));

    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JodaModule());
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    String json = mapper.writer().writeValueAsString(person);

    Person returnPojo = mapper.readValue(json, Person.class);

    System.out.print(returnPojo);