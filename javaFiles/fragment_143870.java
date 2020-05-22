in class1
synchronized void waitMethod() {
    while(someCondition()) {
        wait(); 
    }
}

in class2
synchronized void notifyMethod() {
    notify(); // call notifyAll on class2 will not stop the wait on class1
}