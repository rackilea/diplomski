public Test(int a, int b, String c, long d, float e) {
    this.a = a;
    this.b = b;
    this.c = c;
    this.d = d;
    this.e = e;
}

public Test(int a, int b) {
    this(a, b, "Test", 0L, 3.14F);
}