final class Entity {
    private final int rank;
    private final String name;
    public Entity(int rank, String name) {
        this.rank = rank;
        this.name = name;
    }
    public int getRank() { return rank; }
    public String getName() { return name; }
}

public static List<Entity> mergeAndSort(List<Entity> entities) {
    Map<String, Entity> map = new HashMap<>();
    for (Entity current : entities) {
        Entity previous = map.get(current.getName());
        if (previous == null || previous.getRank() < current.getRank()) {
            map.put(current.getName(), current);
        }
    }
    List<Entity> result = new ArrayList<>(map.values());
    Collections.sort(result, new Comparator<Entity>() {
            public int compare(Entity lhs, Entity rhs) {
                return Integer.compare(lhs.getRank(), rhs.getRank());
            }
        });
    return result;
}