public class YourClassName <T extends Comparable<T>> {
    //Other methods and constructors goes here

    public void set(int i, T elem) throws SortingException {
        if(i<0 || i>=(this.array).size()) throw new SortingException("ERRORE!");
        return (this.array).set(i, elem);
    }

    public T get(int i) throws SortingException{
        if(i<0 || i>=(this.array).size()) throw new SortingException("ERRORE!");
        return (this.array).get(i);
    }
}