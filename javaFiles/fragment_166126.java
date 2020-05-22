public static void main(String[] args) {
    final MyObj  obj = new MyObj();
    Timer t = new Timer();
    t.schedule(new TimerTask(){
        public void run(){
            obj.set(0.5);
        }
    },500);

    System.out.println(obj.get());

}

private static class MyObj {
    private double od;
    public void set(double val) {
        od = val;
    }
    public double get() {
        return od;
    }
}