List<Author> list = new ArrayList<Author>(unSortedMap.values());

Collections.sort(list, new Comparator<Author>() {
    public int compare(Author a, Author b) {
        return a.name.compareTo(b.name);
    }
});