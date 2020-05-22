t.start();
try {
    t.join();
} catch (InterruptedException e) {
    e.printStackTrace();
}
System.out.println("Your Message");