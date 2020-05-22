SomeClass getIt() {
    if (it == null)
        it = new SomeClass();
    return it;
}

...
getIt().someMethod();