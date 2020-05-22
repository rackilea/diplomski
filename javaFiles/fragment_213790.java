public synchronized void setFoo(long value) {
    this.foo = value;
}

public synchronized long getFoo() {
    return this.foo;
}
// no other use of foo outside of these two methods, unless also synchronized