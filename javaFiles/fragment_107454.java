<T> LinkedList<T> deepCloneOneLevel (final LinkedList<T> input, Function<T,T> factory){
    if(input != null){
        LinkedList<T> clone = new LinkedList<>();
        for (T t: input){   
            clone.add(factory.apply(t));
        }
        return clone;
    }
    return null;
}