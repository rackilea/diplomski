// T is the store type and U is the original type (String from file for instance...)
public interface StoreUnit<T, U> {

    void update(U record);

    List<T> list();

}