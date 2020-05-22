public class CorrectlyDisplayedDouble extends Number{
    private final Double internal;

    public CorrectlyDisplayedDouble(Double internal){
        this.internal = internal;
    }

    public int intValue(){
        return internal.intValue();
    }

    public long longValue(){
        return internal.longValue();
    }

    public float floatValue(){
        return internal.floatValue();
    }

    public double doubleValue(){
        return internal.doubleValue();
    }

    public String toString(){
        // replaces periods with commas
        return internal.toString().replace(".", ",");
    }
}