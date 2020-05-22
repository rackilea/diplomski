@Test
public void should_calc_age() {

    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

    modelMapper.createTypeMap(Person.class, PersonDto.class)
            .addMappings(mapper ->
                    mapper
                            // This is your converter.
                            // Here you have access to getSource() (birthdate).
                            .using(ctx -> calcBirthdate((LocalDate) ctx.getSource()))

                            // Now define the mapping birthdate to age
                            .map(Person::getBirthdate, PersonDto::setAge));

    // test that all fields are mapped
    modelMapper.validate();

    // test that the age is calculated
    Person person = new Person();
    person.setBirthdate(birthdate);
    PersonDto personDto = modelMapper.map(person, PersonDto.class);
    assertTrue(personDto.age == age);
}