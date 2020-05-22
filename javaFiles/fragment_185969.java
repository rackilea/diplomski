List<Container> containers = new ArrayList<>();

containers.add(/* ... */);
containers.add(/* ... */);
containers.add(/* ... */);
containers.add(/* ... */);
containers.add(/* ... */);
containers.add(/* ... */);

Map<Type, List<Container>> split = new HashMap<>();

for (Container container : containers) {
    if (!split.containsKey(container.getType())) {
        split.put(container.getType(), new ArrayList<Container>());
    }
    split.get(container.getType()).add(container);
}

List<List<Container>> listOfLists = new ArrayList<>(split.values());