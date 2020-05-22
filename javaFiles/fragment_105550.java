List<Human> humans = new ArrayList<Human>();
for (Creature creature : creatures) {
    if (creature instanceof Human) {
        humans.add((Human) creature);
    }
}