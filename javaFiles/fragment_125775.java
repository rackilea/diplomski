class MyClass<T> {
    // CAN'T DO THIS:
    T[] array = new T[2];

    // can do this:
    T[] array = (T[]) new Object[2];

    // or this:
    Object[] array = new Object[2];  // (and cast later)
}