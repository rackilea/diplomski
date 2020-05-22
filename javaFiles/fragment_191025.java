public class A {
    public String text;
    public String moreText;
}

//Create an instance of the above:
A a = new A();
//property access for public properties requires no getters/setters from within or without the package
a.text = "Hello";
a.moreText = "World";
boolean b = "Hello".equals(a.text); //true