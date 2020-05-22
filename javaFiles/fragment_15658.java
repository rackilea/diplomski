private class PersonCaptionGenerator implements CaptionComposer<Person> {
    @Override
    public String getCaption(Person person) {
        return person.getName() + " " + person.getSurname();
    }
}