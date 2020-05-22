volatile int foo = 0;
int bar = 0;

void thread1() {
    bar = 1;
    foo = 1; // write to volatile variable
}

void thread2() {
    if (foo == 1) { // read from volatile variable
        int r = bar; // r == 1
    }
}