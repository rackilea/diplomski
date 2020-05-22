public class PersonViewModel {

    private final StringProperty name = new SimpleStringProperty();

    public StringProperty nameProperty() {
        return name ;
    }
    public final String getName() {
        return nameProperty().get();
    }
    public final void setName(String name) {
        nameProperty.set(name);
    }

    private final IntegerProperty age = new SimpleIntegerProperty();
    public IntegerProperty ageProperty() {
        return age ;
    }
    public final int getAge() {
        return ageProperty().get();
    }
    public final void setAge(int age) {
        ageProperty.set(age);
    }

    public boolean validAgeInput(String input) {
        // must support partial entry while editing, including empty string
        // accept any integer from 0 - 135 (arbitrary upper bound example)
        String regex = "([0-9]{0,2})|(1[0-2][0-9])|(13[0-5])";
        return input.matches(regex);
    }

}