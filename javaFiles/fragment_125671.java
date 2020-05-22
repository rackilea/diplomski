public <T> List<T> getItemsByType(Class<T> clazz) {
    List<T> theList = new ArrayList<T>();
    //using Object since you never specified which type of elements holds this list
    for (Object o : items) {
        if(clazz.isInstance(o)) {
            //do your logic here...
            theList.add(clazz.cast(o));
        }
    }
    return theList;
}