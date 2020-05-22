try {
    loginEntity = datastore.get(KeyFactory.createKey("login", id));
    loginEntity.setProperty("password", "admin@123");
    datastore.put(loginEntity);
} catch (EntityNotFoundException e) {
// This should never happen
}