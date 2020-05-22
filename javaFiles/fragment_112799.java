//using this you will understand meaning of volatile
while (isTrue) {
    System.out.println("In loop!");
    try {
        Thread.sleep(100);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}