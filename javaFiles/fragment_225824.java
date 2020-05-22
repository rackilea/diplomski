class MyException1 extends Exception {
}    

void a() {
    try {
        while (check()) {
            b();
        }
    } catch (MyException1 ex) {
         // we're already outside the loop; nothing to be done here
    }
}

void b() throws MyException1 {
    c();
}

void c() throws MyException1 {
    if (check2()) {
        throw new MyException1();
    }
    doSomething();
}