import com.fasterxml.jackson.annotation.JsonSetter;

public class TypeAContent {
    private String someField;
    private String anotherField;

    @JsonSetter("some_field")
    public void setSomeField(String someField) {
        this.someField = someField;
    }

    public String getSomeField() {
        return someField;
    }

    @JsonSetter("another_field")
    public void setAnotherField(String anotherField) {
        this.anotherField = anotherField;
    }

    public String getAnotherField() {
        return anotherField;
    }
}