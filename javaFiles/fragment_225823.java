void d() {
    label2: while(check()) {
        e();
    }
    doSomething();
}

void e() {
    f();
}

void f() {
    if (check2()) {
        continue label2;
    }
    doSomething();
}