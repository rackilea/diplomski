private void myMethod() {
    List<MyObject> original = /* your code here */

    List<MyObject> withNames = new ArrayList<>();
    List<MyObject> noNames = new ArrayList<>();

    for (MyObject o : original) {
        if (o.pictureName != null) {
            withNames.add(o);
        }
        else {
            noNames.add(o);
        }
    }

    int size = Math.min(withNames.size(), noNames.size());
    List<MyObject> newList = new ArrayList<>(size);

    for (int i = 0; i < size; i++) {
        newList.add(withNames.get(i));
        newList.add(noNames.get(i));
    }

    // now you have the same number of named and unnamed objects in `newList`
}