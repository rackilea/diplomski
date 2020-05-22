class G {
    private Class messageType;
    private Header header;
    private Data data;

    public G(Class<?> klass, Header header, Data data) {
        this.messageType = klass;
        this.header = header;
        this.data = data;
    }
}

class GFactory {
    private Map<Class<?>, Function<Object, G>> mappings;

    public <T> void register(
             Class<T> klass,
             Function<T, Header> headerExtractor,
             Function<T, Data> dataExtractor) {
        Function<Object, T> cast = klass::cast;
        mappings.put(klass, cast.andThen(t ->
             new G(klass, headerExtractor.apply(t), dataExtractor.apply(t)))); 
    }

    public G createG(Object message) {
        return mappings.get(message.getClass()).apply(message);
    }

    private GFactory() {
        register(A.class, A::getHeader, A::getData);
    }
}