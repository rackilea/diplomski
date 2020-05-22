Map<Class<? extends Entity>, Table<? extends Entity>> tables;

public void <T extends Entity> addTable(Class<T> cls, Table<T> table) {
    tables.put(cls, table);
    // alternately make it possible to get the target class from the table
}

@SuppressWarnings("unchecked")
public <T extends Entity> Table<T> getTable(Class<T> cls) {
    return (Table<T>) tables.get(cls);
}