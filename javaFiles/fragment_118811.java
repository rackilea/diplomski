Mapper<Person, PersonDTO> mapper = Datus.forTypes(Person.class, PersonDTO.class).immutable(PersonDTO::new)
    .from(Person::getFirstName).to(ConstructorParameter::bind)
    .from(Person::getLastName)
        .given(Objects::nonNull, ln -> ln.toUpperCase()).orElse("fallback")
        .to(ConstructorParameter::bind)
    .build();