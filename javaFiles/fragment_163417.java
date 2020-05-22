public abstract class MyClass<T extends MyClass<T>> implements Comparable<T> {

}

public class SubClass extends MyClass<SubClass> {

    @Override
    public int compareTo(SubClass o) {
        // TODO Auto-generated method stub
        return 0;
    }

}