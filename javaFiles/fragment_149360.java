private HashMap<Class<? extends IBase>, IFactory<? extends IBase>> map;

@SuppressWarnings("unchecked")
public <T> T create(Class<T> type) {
    return (T) map.get(type).getInstance();
}