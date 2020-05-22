Map<Integer,Optional<Item>> map=ids.stream()
    .collect(Collectors.toMap(id -> id, id -> Optional.empty()));
items.forEach(item ->
    map.computeIfPresent(item.getId(), (i,o)->o.isPresent()? o: Optional.of(item)));
for(ListIterator<Integer> it=ids.listIterator(ids.size()); it.hasPrevious();) {
    map.get(it.previous()).ifPresent(item -> {
        // do stuff
    });
}