class Custom<T> {
    private T t;
    public Custom (T t) {this.t = t;}
    public T[] toArray() {return (T[]) new Object[] {t};} // if not Object[], what type?
}

Custom<String> custom = new Custom("hey");
String[] arr = custom.toArray(); // fails