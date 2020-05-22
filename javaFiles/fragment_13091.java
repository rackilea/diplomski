while (true) {
    while (value == 0) {
        value = utils.getValue();
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {
        }
        System.out.println("Value is zero");
    }
    System.out.println("Value isn't zero, out of loop");
}