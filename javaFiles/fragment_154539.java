public void deleteMyObjects(Long[] ids) {
    Objectify txn = null;
    try {
        txn = txn();
        List<Key<MyObject>> keys = new ArrayList<Key<MyObject>>();
        for (long id : ids) {
            keys.add(new Key<MyObject>(MyObject.class, id));
        }
        txn.delete(keys);
        commit(txn);
    } finally {
        rollbackIfNeeded(txn);
    }
}