// Get the ids as a List so we can use indexOf()
final List<String> ids = Arrays.asList(idList); 

// After executing this single line, list will be sorted in idList order:
Collections.sort(list, new Comparator<Book>() {
    public int compare(Book o1, Book o2) {
        return ids.indexOf(o1.getId()) - ids.indexOf(o2.getId());
    }
});