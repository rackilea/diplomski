void somethingStranger() {
    int code = somethingsWrongWithTheState(); // <-- Error code: BAD
    if ( code == SomeClass.ILLEGAL_STATE ) {
        internalFlag = SomeOther.SOME_STATE;
        return;
    }
 }