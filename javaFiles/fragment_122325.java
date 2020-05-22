class WithSetter {
    private int value;

    public WithSetter(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void incrementValue() {
        ++this.value;
    }

    public int getValue() {
        return this.value;
    }
}

class ExampleWith {
    public static void main(String[] args) {
        var w = new WithSetter(0);
        w.incrementValue();
        System.out.println(w.getValue()); // 1
        w.setValue(7);                           // <=== Works just fine
        System.out.println(w.getValue()); // 7
    }
}