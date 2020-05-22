int keyToDelete = 7; // Arbitrary number
Iterator<Map<Integer, String>> iter = cars.iterator();

while(iter.hasNext()) {
    Map<Integer, String> map = iter.next();
    if (map.containsKey(keyToDelete)) {
        iter.remove();
    }
}