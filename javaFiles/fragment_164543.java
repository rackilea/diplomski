public <T>
ArrayList<T> myFunction(Class<T> clazz) {
    ArrayList<T> myList = new ArrayList<T>();
    T myObject = null;
    try {
        myObject = clazz.newInstance();
    } catch (Exception e) {
    }
    myList.add(myObject);
    return myList;
}