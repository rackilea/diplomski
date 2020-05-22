class Main {

    class Box {
        int value;
    }

    void foo() {
        Box box = new Box();
        Runnable r = () -> box.value++;
    }
}