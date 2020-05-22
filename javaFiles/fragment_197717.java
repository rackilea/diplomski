public void insertDerp(String name, int age) {
    insertDerp(UUID.randomUUID().toString(), name, age);
}

@SqlUpdate("INSERT INTO derps (id, name, age) VALUES (:id, :name, :age)")
protected abstract void insertDerp(@Bind("id") String id, @Bind("name") String name, @Bind("age") int age);