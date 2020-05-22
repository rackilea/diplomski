HashMap<Book> yourMap;

Collection<Book> entries = yourMap.values();
Iterator<Book> iterator = entries.iterator();
while(iterator.hasNext()) {
    Book curBook = iterator.next();
    if (yourConditionToRemove) {
        iterator.remove();
    }
}