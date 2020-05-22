@XmlRootElement(name = "datacenter")
public class DataCenter {
    /**
     * K: storageId V: storage
     */
    @XmlElement(name = "storages")
    @XmlJavaTypeAdapter(StorageMapAdapter.class)
    private final Map<String, Storage> storages = new LinkedHashMap<String, Storage>();
}

@XmlJavaTypeAdapter(StorageMapAdapter.class)
@XmlAccessorType(XmlAccessType.FIELD)
public class Storage {

    @XmlAttribute(name = "id")
    private String id;

    /**
     * K: repository.id V: Repository
     */
    @XmlElement(name = "repositories")
    @XmlJavaTypeAdapter(RepositoryMapAdapter.class)
    private final Map<String, Repository> repositories = new LinkedHashMap<String, Repository>();

}

public class StorageMap {
    @XmlElement(name = "storage")
    List<Storage> entries = new ArrayList<Storage>();

    public List<Storage> getEntries() {
        return entries;
    }
}

public class StorageMapAdapter extends XmlAdapter<StorageMap, Map<String, Storage>> {

    @Override
    public StorageMap marshal(Map<String, Storage> map) throws Exception {
        StorageMap storageMap = new StorageMap();
        for (Map.Entry<String, Storage> entry : map.entrySet()) {
            storageMap.getEntries().add(entry.getValue());
        }
        return storageMap;
    }

    @Override
    public Map<String, Storage> unmarshal(StorageMap storageMap) throws Exception {
        List<Storage> adaptedEntries = storageMap.entries;
        Map<String, Storage> map = new LinkedHashMap<String, Storage>(adaptedEntries.size());
        for (Storage storage : adaptedEntries) {
            map.put(storage.getId(), storage);
        }
        return map;
    }
}

@XmlRootElement(name = "repository")
@XmlAccessorType(XmlAccessType.FIELD)
public class Repository {
    @XmlAttribute(name = "id")
    private String id;

    @XmlAttribute(name = "policy")
    private String policy;
}

public class RepositoryMap {
    @XmlElement(name = "repository")
    List<Repository> entries = new ArrayList<Repository>();

    public List<Repository> getEntries() {
        return entries;
    }
}

public class RepositoryMapAdapter extends XmlAdapter<RepositoryMap, Map<String, Repository>> {

    @Override
    public RepositoryMap marshal(Map<String, Repository> map) throws Exception {
        RepositoryMap repositoryMap = new RepositoryMap();
        for (Map.Entry<String, Repository> entry : map.entrySet()) {
            repositoryMap.getEntries().add(entry.getValue());
        }
        return repositoryMap;
    }

    @Override
    public Map<String, Repository> unmarshal(RepositoryMap repositoryMap) throws Exception {
        List<Repository> adaptedEntries = repositoryMap.entries;
        Map<String, Repository> map = new LinkedHashMap<String, Repository>(adaptedEntries.size());
        for (Repository repository : adaptedEntries) {
            System.out.println("Reading repository " + repository.getId());
            map.put(repository.getId(), repository);
        }
        return map;
    }
}