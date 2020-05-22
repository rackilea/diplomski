class Z {
    private static int state;
    public void oneAtATime(){
        synchronized (Z.class) {
            state++;
        }
    }
}