public class TestA {
    public String [] theStrings;

    public TestA() {
        theStrings = new String[] {"one","two", "three"};
        for(String string : getTheStrings()) {
            System.out.println(string);
        }
    }

    public String[] getTheStrings() {
        System.out.println("get the strings");
        return theStrings;
    }

    public static void main(String [] args) {
        new TestA();
    }
}