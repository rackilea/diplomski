class StringChain  {

    private StringBuilder[] builders;

    public StringChain(StringBuilder[] builders) {
        this.builders = builders;
    }

    public String toString() {
        String finalStr = "";
        for (StringBuilder b : builders)
            finalStr += b;
        return finalStr;
    }
}

....

public static void main(String []args){
    StringBuilder a = new StringBuilder("a"); //Create StringBuilder a
    StringBuilder b = new StringBuilder("b"); //Create StringBuilder b
    StringChain chain = new StringChain(new StringBuilder[] { a, b }); //Pass both builders to the String Chain
    System.out.println(chain);
    setStringBuilderValue(b, "c");
    System.out.println(chain);
 }

 private static void setStringBuilderValue(StringBuilder b, String value) {
     b.replace(0, b.length(), value);
 }