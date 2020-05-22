SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
System.out.println(dateFormat.format(new Date()));
try {
    Thread.sleep(2000); 
    System.out.println("2s delayed");
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
System.out.println(dateFormat.format(new Date())); // different Date object to get fresh time