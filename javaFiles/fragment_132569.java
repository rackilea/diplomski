private void callMe() {
    synchronized(this) {
        System.out.println("Started");
        for (int i = 1; i <= 5; i++) {
            System.out.println(name+" = "+i);
        }
    }
}