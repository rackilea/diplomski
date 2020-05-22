static interface Inter {
    public void method();
}

public static void main(String[] args) {
    var inter = new Inter() {
        @Override
        public void method() {System.out.println("popo");}
    };
    inter.method();
    inter = new Inter() {
        @Override
        public void method() {System.out.println("koko");}
    };
    inter.method();
}