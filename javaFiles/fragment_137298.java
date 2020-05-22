synchronized void foo() {
    if(expensiveAccessCheck()) {
        update();
    }
}

void foo() {
    if(expensiveAccessCheck()) {
        synchronized(foolock) {
            update();
        }
    }
}