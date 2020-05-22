<T extends MyClone<? super T>> LinkedList<T> deepCloneOneLevel (final LinkedList<T> input){
    if(input != null){
        LinkedList<T> clone = new LinkedList<>();
        for (T t: input){   
            clone.add(t.clone());
        }
        return clone;
    }
    return null;
}