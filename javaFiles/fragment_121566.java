void thread1() {
    Node temp = root; // read from volatile variable
    temp.numOfKeys = 1;
}

void thread2() {
    Node temp = root; // read from volatile variable
    int r = temp.numOfKeys;
}