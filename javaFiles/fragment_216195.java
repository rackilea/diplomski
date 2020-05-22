public class PersonLabel extends JLabel {
    private Person person;
    public void setPerson(Person person) {
        this.person = person;
        setText(person == null ? null : person.toString());
    }

    public Person getPerson() {
        return person;
    }
}