@NotNullIfAnotherFieldHasValue.List({
    @NotNullIfAnotherFieldHasValue(
        fieldName = "status",
        fieldValue = "Canceled",
        dependFieldName = "fieldOne"),
    @NotNullIfAnotherFieldHasValue(
        fieldName = "status",
        fieldValue = "Canceled",
        dependFieldName = "fieldTwo")
})
public class SampleBean {
    private String status;
    private String fieldOne;
    private String fieldTwo;

    // getters and setters omitted
}