@When("^I populate a field with a new value$")
    public void iPopulateAFieldWithANewValue(List<Person> persons) throws Throwable {
    for (Person p : persons) {
        ...
    }
}