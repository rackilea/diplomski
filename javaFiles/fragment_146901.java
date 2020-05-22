public class SomeClass implements Barkable {
    private Dog dog;

    @Override
    public void bark() {
       dog.bark();
    }
}

public class Dog implements Barkable {

    @Override
    public void bark() {
       System.out.println( "Bark! Bark!" );
    }
}