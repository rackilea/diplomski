String birthday= tfBirthday.getText();
personQuery query = Application.getPersonQuery();
List<Person> persons= query.getPerson(birthday);

for(int i = 0; i < persons.size(); i++){
    tfcSelectName.addItem(persons.get(i));
}