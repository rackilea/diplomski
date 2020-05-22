synchronized(someObject) {
    someObject.wait();
}
synchronized(this) {
    wait();
}