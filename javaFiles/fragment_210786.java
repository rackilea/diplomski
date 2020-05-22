Iterator<Float> iterator = map.values().iterator();
while (iterator.hasNext()) {
    if (iterator.next() == 0f) {
        iterator.remove();
    }
}