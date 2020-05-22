package myFileAPI;

public abstract class File {

    public static TypeInfo getTypeInfo() {
        throw new IllegalStateException(
                    "Type info hasn't been set up in the subclass");
    }

}