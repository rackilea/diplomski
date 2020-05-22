public class HashMapBackedSet<T> extends HashMap<T,T>{
    public T add( T toAdd ){
        T existing = get( toAdd );
        if( existing != null ){
            return existing;
        }
        put( toAdd, toAdd );
        return toAdd;
    }
}