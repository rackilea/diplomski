public int select_cart() {
    Random r = new Random();
    int random = r.nextInt(getCartNumber()) + 1;
    int selection = random;
    try {
        Thread.sleep(5000);
    } catch (InterruptedException ex) {
    }
    return selection;
}