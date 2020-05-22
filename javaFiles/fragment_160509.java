private Class<T> clazz;

public Runner(Class<T> clazz) {
    this.clazz = clazz;
}

// ...

public void runFile() {
    // do smth with
    clazz.getName()
}