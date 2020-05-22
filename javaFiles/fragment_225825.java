class MyException2 extends Exception {
} 

void d() {
    while(check()) {
        try {
            e();
            doSomething();
        } catch (MyException2 ex) {
            // nothing to do here; We're already at the end of the loop body
        }
    }
}

void e() throws MyException2 {
    f();
}

void f() throws MyException2 {
    if (check2()) {
        throw new MyException2();
    }
    doSomething();
}