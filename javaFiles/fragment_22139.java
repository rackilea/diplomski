// define the interface to represent an arbitrary function
interface Function<T> {
    void Func(T el);
}

// now the method to apply an arbitrary function to the list
<T> void applyFunctionToArrayList(ArrayList<T> list, Function<T> func){
    // iterate over the list
    for(T item : list){
        // invoke the "arbitrary" function
        func.Func(item);
    }
}