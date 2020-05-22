class Car<X extends Car<X>> {
    public X myself() {
        return (X) this;
    }
}

class Ferrari extends Car<Ferrari> {
}