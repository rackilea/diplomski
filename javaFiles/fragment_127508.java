class Foobar {
    public static volatile Foobar instance = new Foobar(42);
    public int value;
    public Foobar(int value) { this.value = value; }
}

int reader() {
    return Foobar.instance.value;
}

void writer(int value) {
    Foobar.instance = new Foobar(value);
}