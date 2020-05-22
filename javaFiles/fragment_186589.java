void removeDuplicates(List<String> list) {
    Set set = new HashSet();
    Iterator<String> iterator = list.iterator();

    while (iterator.hasNext()) {
        Object element = iterator.next();
        if (!set.add(element)){
            iterator.remove();
        }
    }
}