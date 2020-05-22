public class Example {
    private String str;

    public class Inner {
        void show() {
            // Show the string for the Example this Inner is part of
            System.out.println(Example.this.str);
        }
    }

    public Example(String s) {
        this.str = s;
    }

    public static void main(String[] args) {
        Example e1 = new Example("e1");
        Example e2 = new Example("e2");
        Inner i1 = e1.new Inner();
        i1.show(); // "e1"
        Inner i2 = e2.new Inner();
        i2.show(); // "e2"
    } 
}