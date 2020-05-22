static class A {
    static class Thing {
        public int value() {
            return 10 + value2();
        }
        public int value2() {
            return 10;
        }
    }
    protected Thing createThing() {
        return new Thing();
    }
    public String toString() {
        return Integer.toString(createThing().value());
    }
}

static class B extends A {
    static class Thing extends A.Thing {
        public int value2() {
            return 20; 
        }
    }
    @Override
    protected Thing createThing() {
        return new Thing(); // creates B.Thing
    }
}

public static void main(String[] args) {
    System.out.println(new B());
}