Map<Integer, Dragon> idToDragon = new HashMap<>();
for (Dragon d : yourArray) {
    // fetch existing dragon with that id or create one if none present
    Dragon t = idToDragon.computeIfAbsent(d.getId(), i -> new Dragon(i, 0));
    // add counts
    t.setCount(t.getCount() + d.getCount());
    // store in map
    idToDragon.put(d.getId(), t);
}