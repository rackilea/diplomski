class WithoutSetter {
    private int value;

    public WithoutSetter(int value) {
        this.value = value;
    }

    public void incrementValue() {
        ++this.value;
    }

    public int getValue() {
        return this.value;
    }
}

class ExampleWithOut {
    public static void main(String[] args) {
        var w = new WithoutSetter(0);
        w.incrementValue();
        System.out.println(w.getValue()); // 1
        w.setValue(7);                           // <=== Won't compile
        w.value = 7;                             // <=== Also won't compile
        System.out.println(w.getValue());
    }
}