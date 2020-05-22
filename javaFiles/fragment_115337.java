public enum SHAPE {


    LINE("LINE", 3),
    CIRCLE("CIRCLE", 4),
    TEXT("TEXT", 5);

    public final String shapeName;
    public final int shapeValue;
    public static final SHAPE[] arrayOfShap = values();

    static {
        // This is used to do some operations on enum generally like creating a map of this enums. 
    }

    SHAPE(String name, int value){
        this.shapeName = name;
        this.shapeValue = value;
    }

    // Here one can define static methods to get enum values from arrays, map etc....
}