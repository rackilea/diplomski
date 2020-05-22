while (b) {
    System.out.println("In loop!");
    try {
        Thread.sleep(100);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    //you need to use the volatile variable in order to understand volatile
    b = isTrue;
}