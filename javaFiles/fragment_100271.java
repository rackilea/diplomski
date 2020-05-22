if (updates.size() == 1) {
    Map.Entry entry = updates.entrySet().iterator().next();
    store.store(entry.getKey(), entry.getValue());
} else if (updates.size() > 1) {
    store.storeAll(updates);
}