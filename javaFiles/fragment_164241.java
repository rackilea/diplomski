public class Person {

    protected SimpleStringProperty personName;
    protected SimpleBigIntegerProperty ageInSeconds;

    public Person() {
        this.personName = null;
        this.ageInSeconds = null;
    }

    public Person(String person_name, BigInteger age_in_seconds) {
        this.personName = new SimpleStringProperty(person_name);
        this.ageInSeconds = new SimpleBigIntegerProperty(age_in_seconds);
    }

    public void setPersonName(String person_name) {
        this.personName = new SimpleStringProperty(person_name);
    }

    public void setAgeInSeconds(BigInteger age_in_seconds) {
        this.ageInSeconds = new SimpleBigIntegerProperty(age_in_seconds);
    }

    public String getPersonName() {
        return this.personName.getValue();
    }

    public BigInteger getAgeInSeconds() {
        return this.ageInSeconds.getValue();
    }
}