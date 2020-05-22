public class Foo{

    protected class Bar{}

    public static void main(String[] args){
        Foo.Bar bar = (new Foo()).new Bar();
    }
}