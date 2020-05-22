import com.fasterxml.jackson.annotation.JsonSetter;

public class TypeBContent {
    private String someField;
    private String anotherField;

    @JsonSetter("some_field_b")
    public void setSomeField(String someField) {
        this.someField = someField;
    }

    public String getSomeField() {
        return someField;
    }

    @JsonSetter("another_field_b")
    public void setAnotherField(String anotherField) {
        this.anotherField = anotherField;
    }

    public String getAnotherField() {
        return anotherField;
    }
}