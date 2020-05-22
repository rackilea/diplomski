void a() {
    label1: while (check()) {
        b();
    }
}

void b() {
    c();
}

void c() {
    if (check2()) {
        break label1;
    }
    doSomething();
}