public class HashTable<T> {

    private LinkedList<T> table[];

    @SuppressWarnings("unchecked")
    public HashTable(int size) {
        table = new LinkedList[size];
    }

}