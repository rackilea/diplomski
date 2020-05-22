public class Foo{

    //Instantiated before constructor
    final Bar bar1 = new Bar();

    //Instantiated by constructor    
    final Bar bar2;

    //Instantiated after constructor
    final Bar bar3 = this.bar2;

    //Compile time error
    final Bar bar3 = bar2;

    public Foo(Bar bar) {
        this.bar2 = bar;
    }
}