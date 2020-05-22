Thread performer = new Thread(c);
//...
try {
    performer.join();
} catch(InterruptedException e) {
    System.out.println("Ooops");
}