public void timer() {
    for(int i=0; i<6; i++) {
        try {
            Thread.sleep(250L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}