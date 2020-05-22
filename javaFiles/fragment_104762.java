public class IteratorMissingFirst<E> implements Iterator<E>{

private Iterator<E> underlyingIterator;
private E firstElement;
private boolean firstElOffered;

public IteratorMissingFirst(E firstElement, Iterator<E> it){
    //initialize all the instance vars
}

public boolean hasNext(){
    if(!firstElOffered && firstElement != null){
            return true;
    }
    else{
        return underlyingIterator.hasNext();
    }
}

public E next(){
    if(!firstElOffered){
        firstElOffered = true;
        return firstElement;
    }
    else return underlyingIterator.next();
}

public void remove(){

}
}