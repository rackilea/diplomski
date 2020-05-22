class StoreList {
    public boolean hasStore(Store store) {
        return stores.contains(store);
    }
}

class Manager {
    private final StoreList stores;

    public boolean hasStoreInStoreList(Store store) {
        return stores.hasStore(store);
    }

    public Stream<Store> getStores() {
        return stores.getManagedStores(this);
    }
}

class Store {
    public void setManager(Manager manager) {
        if (manager.hasStoreInStoreList(this))
            this.manager = manager;
        else
            throw new IllegalArgumentException("Manager for different stores");
    }
}