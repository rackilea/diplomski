public class StringIntTuple{
    public final int intValue;
    public final String stringValue;
    public StringIntTuple(int intValue, String stringValue){
        this.intValue = intValue;
        this.stringValue = stringValue;
    }
    public String toString(){
        return "(" + this.intValue + ", " + this.stringValue + ")";
    }

}