public Something someMethod() {
    try {
        if(someStatement) {
            return new Something();
        } else {
            return new SomethingElse();
        }
    } finally {
        // this is always executed, even if there is an Exception
    }
}