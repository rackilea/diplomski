class A {
    void foo(String s) { ...  }
}

class B extends A {
    // Note generalized type
    @Override void foo(Object s) { ...  }
}