private static final Map<Long, Animal> byId = new HashMap<Long, Animal>(3);
static {
    for (Animal e : Animal.values())
        byId.put(e.id(), e);
}
public static Animal byId(long id) { return byId.get(id); }