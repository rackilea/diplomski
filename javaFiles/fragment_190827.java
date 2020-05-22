public interface ObjectWithId {
    int getId();
}

public class Student implements ObjectWithId {
    // ...
}

public class Teacher implements ObjectWithId {
    // ...
}


public class ListFromFile<T extends ObjectWithId> extends ArrayList<T> {
    public T getElement(int id) {
        for ( T o : this ) {
            if ( o.getId() == id ) {
                return o;
            }
        }

        return null;
    }
}