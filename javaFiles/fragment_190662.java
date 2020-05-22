public List<String> getStrings() throws InterruptedException {
    System.out.println(Thread.currentThread().getId() + " goes to sleep");
    Thread.sleep(1000);
    System.out.println(Thread.currentThread().getId() + " awoke");
    if (strings == null) {
        strings = loadStrings();
    }
    return strings;
}