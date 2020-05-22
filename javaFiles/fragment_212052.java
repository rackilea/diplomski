private static interface Inner {
    void setA(String a);
}

private  static Inner createInner() {
    return new Inner() {
        private String a;

        @Override
        public void setA(String a) {
            this.a = a;
        }
    };
}