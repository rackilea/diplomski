public abstract class AbstractMapService<T> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(Long aLong) {
        return map.get(aLong);
    }

    T save(Long aLong, T object){
       map.put(aLong, object);
       return object;
    }

    void deleteById(Long aLong){
        map.remove(aLong);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {
        return Collections.max(map.keySet()) + 1L;
    }
}