public class MyClass {
    MyClass(CharSequence charSeq) {
        System.out.println("CharSequence");
    }
    MyClass(String s) {
        System.out.println("String");
    }   
    public static void main(String[] args) {
        new MyClass(null); // prints "String"
        new MyClass(""); // prints "String"
        new MyClass((CharSequence) null); // prints "CharSequence"
        new MyClass((CharSequence) "");   // prints "CharSequence"
    }
}