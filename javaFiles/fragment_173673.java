public void doSomething() {
    String someString;
    T lastValueCopy = lastValue;
    if (lastValueCopy != null) {
        someString += lastValueCopy.toString();
    }
}