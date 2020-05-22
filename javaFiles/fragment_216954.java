package myFileAPI;

public class TextFile extends File {

    private static final TypeInfo typeInfo
                      = new TypeInfo("Text", "Contains text.");

    // Shadow the superclass static method
    public static TypeInfo getTypeInfo() {
        return typeInfo;
    }

}