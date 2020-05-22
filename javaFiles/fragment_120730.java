public void onApplicationEvent(ApplicationReadyEvent e) {
    if (e.getApplicationContext().getParent == null) {
        System.out.println("******************************");
        System.out.println("Post-process begins.");
        System.out.println("******************************");      
    }
}