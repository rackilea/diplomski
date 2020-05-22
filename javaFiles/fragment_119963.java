void method1() {
    Double foo = 1.0;
    Double bar = foo * 2;
}

void method2() {
    Double foo = 1.0;
    Double bar = Double.valueOf(foo.doubleValue() * 2);
}