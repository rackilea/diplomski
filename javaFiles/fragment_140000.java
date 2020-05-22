public void doWhatever(ExtendedClass cls) {
    if (cls instanceof SomeClass) {
        //do stuff
        SomeClass sCls = (SomeClass)cls; // you can cast it to SomeClass
                                         // once you know that it is one
    }
}