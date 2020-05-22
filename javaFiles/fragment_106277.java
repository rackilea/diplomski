public class MyClass<T extends Comparable>
{

    private T value;

    MyClass(T value)
    {
        this.value = value;    
    }

    T getValue() {
        return this.value;
    }

    other code...
}