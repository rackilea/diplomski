class Manager {
    private Optional<List<Store>> managedStores = Optional.empty();

    public void purgeCache() {
        managedStores = Optional.empty();
    }

    public Stream<Store> getStores() {
        if (!managedStores.isPresent())
            managedStores = Optional.of(stores.getManagedStores(this)
                .collect(Collectors.toList()));
        return managedStores.get().stream();
    }
}

class Store {
    public void setManager(Manager manager) {
        if (!manager.equals(this.manager)) {
            this.manager.purgeCache();
            this.manager = manager;
            this.manager.purgeCache();
        }
    }
}