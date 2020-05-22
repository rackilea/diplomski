class Bcd extends B {
    @Override
    Bcd m(Cde a) {
        System.out.println("bcd");
        return a;
    }
}

class Cde extends Bcd {
    @Override
    Cde m(Cde a) {
        System.out.println("cde");
        return a;
    }
}

class B {
    B m(Cde a) {
        System.out.println("b");
        return a;
    }
}

class Test {

    public static void main(String[] args) {
        final B ob1 = new Cde();
        final Cde ob2 = new Cde();
        ob1.m(ob2);
    }
}