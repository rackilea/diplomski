Iterator<Integer> iterator = set.iterator();
while (iterator.hasNext()) {
    Integer element = iterator.next();
    if (element % 2 == 0) {
        iterator.remove();
    }
}