// Here T is your class name
public class Test implements Comparator<T> {
   @Override
    public int compare(T o1, T o2) {
        return (o1.getNumber() - o2.getNumber());
   }    
}