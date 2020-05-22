private void repeat(int times, Runnable action) {
    for (int x = 0; x < times; x++) {
        action.run();
    }
}

...

repeat(5, new Runnable(){
    void run(){
        System.out.println("Hello");
    }
});