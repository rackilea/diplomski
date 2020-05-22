@Test
public void testFindByStatus() throws ParseException {
    for (PersonStatus status : PersonStatus.values()) {
        List<Person> personlist = PersonRepository.findByStatus(status);
        assertThat(personlist, notNullValue());
    }
}