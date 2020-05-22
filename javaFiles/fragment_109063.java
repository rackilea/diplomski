public void eat() {
    synchronized (this) {
        System.out.println("eat");
        eatDinner();
    }
}

public void eatDinner() {
    synchronized (this) {
        System.out.println("eat");
    }
}