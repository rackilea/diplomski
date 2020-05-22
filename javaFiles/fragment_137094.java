public abstract class KeyProfileService<K extends KeyProfileEntity> {

    protected CrudRepository<K, Long> myRepository;

    public List<K> getList() { // using K
        List<K> result = new ArrayList<>(); // here too
        this.myRepository.findAll().forEach(result::add);
        return result;
    }

    public K create(K entity) { // using K
        return this.myRepository.save(entity);
    }
...
}