class MyOtherClass<T> {
    // CAN'T DO THIS, EITHER:
    SomeType<T>[] array = new SomeType<T>[2];

    // can do this:
    SomeType<T>[] array = (SomeType<T>) new SomeType[2];

    // or this:
    SomeType[] array = new SomeType[2];  // (and cast later)
}