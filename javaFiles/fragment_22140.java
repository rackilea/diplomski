// define the interface to represent an arbitrary function
interface Function<T> {
    T Func(T el);
}

// now the method to apply an arbitrary function to the list
<T> ArrayList<T> applyFunctionToArrayList(ArrayList<T> list, Function<T> func){
    ArrayList<T> newList = new ArrayList<T>();

    // iterate over the list
    for(T item : list){
        // invoke the "arbitrary" function
        newList.add(func.Func(item));
    }
}