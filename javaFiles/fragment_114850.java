public <U extends T> SomeContainer<U> subset(Class<U> c){
    SomeContainer<U> output = new SomeContainer<U>();
    for (T val : this) {
        if (c.isInstance(val)) {
            output.add(c.cast(val));
        }
    }
    return output;
}