public <T>
void myFunction(Class<T> clazz, ArrayList<T> myList) {
    T myObject = null;
    try {
        myObject = clazz.newInstance();
    } catch (Exception e) {
    }
    myList.add(myObject);
}