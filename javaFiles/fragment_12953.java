public Object(int temporary) {
    this.temporary = temporary;
}
public void method() {
    try {
        Thread.sleep(3000);
        // upon completion
        exists = true;
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}