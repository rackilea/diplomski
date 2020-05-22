package stackoverflow;

import javafx.beans.property.SimpleStringProperty;

public class TestRow implements Comparable<TestRow> {

    private SimpleStringProperty name;
    private SimpleStringProperty age;

    public TestRow(String name, String age) {
        this.name = new SimpleStringProperty(name);
        this.age = new SimpleStringProperty(age);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public String getAge() {
        return age.get();
    }

    public SimpleStringProperty ageProperty() {
        return age;
    }

    @Override
    public int compareTo(TestRow that) {
        return this.getName().compareTo(that.getName());
    }

}