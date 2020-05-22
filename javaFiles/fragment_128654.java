class OtherClass {
    public static final String ABC = "abc";
}

public class MainJsoup {

    public static void main(String[] args) throws Exception {
        String test = "abc";
        if (test.equals(OtherClass.ABC)) {
            System.out.println("They are equal.");
        } else {
            System.out.println("They are unequal.");
            System.out.println("OtherClass.ABC = " + OtherClass.ABC);
        }
    }
}