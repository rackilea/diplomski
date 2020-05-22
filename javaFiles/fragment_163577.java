class A {
    private int field;

    A(int value) {
        this.field = value;
    }

    public void sayField() {
        System.out.println("(A) field == " + this.field);
    }
}

class B extends A {
    private int field;

    B(int aValue, int bValue) {
        super(aValue);
        this.field = bValue;
    }

    @Override
    public void sayField() {
        super.sayField();
        System.out.println("(B) field == " + this.field);
    }
}