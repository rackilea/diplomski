import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Course {

    private StringProperty courseName = new SimpleStringProperty();

    public Course(String courseName) {
        this.courseName.set(courseName);
    }

    public String getCourseName() {
        return courseName.get();
    }

    public StringProperty courseNameProperty() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName.set(courseName);
    }

    // The ChoiceBox uses the toString() method of our object to display options in the dropdown.
    // We need to override this method to return something more helpful.
    @Override
    public String toString() {
        return courseName.get();
    }
}