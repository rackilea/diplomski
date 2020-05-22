import java.util.ArrayList;
import java.util.List;

public abstract class Heap<T extends Comparable<T>> {

private List<T> data;
private int numberOfElements;

public Heap( int size ) {

    //I am also not sure if this cast will work or is best practice

    data = new ArrayList<T>(size + 1 );

    numberOfElements = 0;
}

public void incrementNumberOfElements() { numberOfElements++; }
public int getNumberOfElements() { return numberOfElements; }
public List<T> getData() { return data; }
public abstract void insert( T element );
}

class MinHeap<T extends Comparable<T>> extends Heap<T> {

public MinHeap( int size ) { super(size); }
public void insert( T element ) {

    incrementNumberOfElements();
    List<T> data = getData();
    int current = getNumberOfElements();
    data.set(current, element);

    //The error is with compareTo()
    while ( current / 2 >= 1 && data.get(current).compareTo( data.get(current / 2) ) < 0 ) {

        //code

    }
}

}