public class TestMap <P extends ParentInterface, E extends P> extends HashMap implements Map {
    void registerall(){
        Class<E> key = (Class<E>) this.keySet().iterator().next();
        Class<P> val = (Class<P>) this.get(key);
        register(key, val);
    }

}