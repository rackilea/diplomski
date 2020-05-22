assertThat(persons, contains(
    either(
            both(hasProperty("firstName", is("Bob")))
            .and(hasProperty("lastName", is("Smith")))
            .and(hasProperty("middleName", is("R.")))
    ).or(
            both(hasProperty("firstName", is("Alex")))
            .and(hasProperty("lastName", is("Black")))
            .and(hasProperty("middleName", is("T.")))
    )
));