public class Generics <T extends Comparable<T>> 
    extends Parent<T> {

    ArrayList<T> ar;

    public Generics() {
        ar = new ArrayList<>();
    }

    public void add(T elt){
        ar.add(elt);
    }
}