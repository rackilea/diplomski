List<Object> someList = new ArrayList<>();
someList.add("an item");

for (Object item : someList) {
    // throws ConcurrentModificationException
    someList.add("a new item");
}