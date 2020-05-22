try {
    ft.t.join(); // Here!
    for (int i =0; i < 5; i++) {
        System.out.println("Main : "+i);
        Thread.sleep(1000);
    }
} catch(InterruptedException e){
    System.out.println("Exception : "+ e);
}