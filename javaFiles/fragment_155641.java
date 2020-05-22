class MyClass {
    private Object finalizer = new Object {
        protected void finalize() {
            if (MyClass.this.p != null) {
                MyClass.this.library.destroy(MyClass.this.p);
                MyClass.this.p = null;
            }
        }
    }
}