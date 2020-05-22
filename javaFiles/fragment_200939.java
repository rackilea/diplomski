public class Json {

public Sheet[] sheets = {};

@JsonTypeInfo(use=Id.NAME, include=As.PROPERTY, property="sheetName")
@JsonSubTypes({
    // list all sheet name : class mapping here
    @Type(name=MetadataSheet.sheetName, value=MetadataSheet.class)
})
static class Sheet {}

static class Sheet1 extends Sheet {
    public static final String sheetName = "Sheet 1";
    public Sheet1Rows[] rows; // subclasses a generic class Row
} 

}