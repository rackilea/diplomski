public enum DeserializerMap {

    INSTANCE;

    private Map<Class<? extends Model>, SerializableObserver> modelObserverMap = new HashMap<>();

    public void registerSerializableObserver(Class<? extends Model> modelClass, SerializableObserver serializableObserver) {
        modelObserverMap.put( modelClass, serializableObserver );
    }

    public void deregisterSerializableObserver(Class<? extends Model> modelClass) {
        modelObserverMap.remove( modelClass );
    }

    public SerializableObserver getSerializableObserver(Class<? extends Model> modelClass){
        return modelObserverMap.get( modelClass );
    }

}