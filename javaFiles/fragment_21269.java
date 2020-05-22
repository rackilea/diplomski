final byte[] myArray = ...;
Logger.getLogger(MyClass.class).debug(new Object() {
    @Override public String toString() {
        return new String(myArray);
    }
});