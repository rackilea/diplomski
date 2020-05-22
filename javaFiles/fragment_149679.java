public class ClassToHandlerMap
{
    private final Map<Class<?>, Handler<?>> map = new HashMap<>();
    public <T extends Marker> void put(Class<T> clazz, Handler<T> handler) {
        map.put(clazz, handler);
    }
    @SuppressWarnings("unchecked")
    public <T extends Marker> Handler<T> get(Class<T> clazz) {
        return (Handler<T>)map.get(clazz);
    }
}