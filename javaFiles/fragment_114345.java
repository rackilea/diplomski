for(int i=0; i < 200; i += 4){
    System.out.println("Hopefully will only run once...per 5 secs");
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}