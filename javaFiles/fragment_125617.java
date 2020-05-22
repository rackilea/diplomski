int counter = 0;
void call() {
    counter++;
    // recursive call
    call()
    counter--;

}