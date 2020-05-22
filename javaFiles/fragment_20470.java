public class Google01 implements Outer{
    // outer class variable, see no final here
    int outer = 0;

    public static void main(String[] args) {
        Google01 inst = new Google01();
        inst.testMe();
    }

    public void testMe(){
        // Inner class
        class temp{
            Outer out;
            public temp(Outer out) {
                this.out = out;
            }
            public void printMe(String text){
                // reading outer variable
                System.out.println(out.getValue() + text);
                // setting outer variable
                out.setValue(out.getValue() + 1);
            }
        }

        // Lets start our test
        temp obj = new temp(this);
        System.out.println("Value of outer before call = " + outer);
        // this should increment outer value, see number before Yahoo in output
        obj.printMe("Yahooo");
        obj.printMe("Google");
        obj.printMe("Bing");
        // Lets print outer value directly.
        System.out.println("Value of outer after call = " + outer);

    }

    @Override
    public void setValue(int value) {
        outer = value;
    }

    @Override
    public int getValue() {
        return outer;
    }
}

// An interface that is use to communicate with outer class variable.
interface Outer{
    void setValue(int value);
    int getValue();
}