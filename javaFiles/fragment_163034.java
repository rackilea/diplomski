private static <T extends Serializable> T doStuff() {
    Response<T> r = ...;

// ...

    return r.getDetails();
}

interface Response<T extends Serializable> {
    // ...

    T getDetails();

    // ...
}