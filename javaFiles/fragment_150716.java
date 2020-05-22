protected void setEntityManager(Object object, EntityManager em) {
    Optional<Field> f = Arrays.stream(object.getClass().getDeclaredFields())
            .filter(x -> x.getType().isAssignableFrom(EntityManager.class)).findFirst();
    if (f.isPresent()) {
        f.get().setAccessible(true);
        try {
            f.get().set(object, em);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}