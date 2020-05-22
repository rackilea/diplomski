Runnable x = new Runnable() {
    private int x = 10;

    @Override public void run() {
        System.out.println(x);
        x++;
    }
};
x.run(); // Prints 10
x.run(); // Prints 11