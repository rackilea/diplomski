public void func(final int param) {
    InnerClass inner = new InnerClass() {
        public void innerFunc() {
            System.out.println(param);
        }
    }

    inner.innerFunc();
}