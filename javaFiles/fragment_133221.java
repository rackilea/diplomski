class Store {
    private Manager manager;

    public Manager hasManager(Manager manager) {
        return this.manager.equals(manager);
    }
}

class StoreList {
    private final List<Store> stores;

    public Stream<Store> getManagedStores(Manager manager) {
        return stores.stream().filter(s -> s.hasManager(manager));
    }
}