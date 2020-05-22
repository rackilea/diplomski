private static final Map<Integer, Class<? extends Comparable>> types = new HashMap<>();
static {
    types.put(1, Long.class);
    types.put(2, Date.class);
}

public List<Long> getSortedIds(int itemType) {
    Class<? extends Comparable> clz = types.get(itemType);
    if (clz != null) {
        List<Item> items = (List<Item>)getItems(itemType, clz);
        Collections.sort(items);
        return items.stream().map(it -> it.id).collect(Collectors.toList());
    }
    //...
    return null;
}