final int[] counter = {n};
final Timer tt = new Timer();
tt.schedule(new TimerTask(){
    public void run() {
        //your job
        counter[0]--;
        if (counter[0] == 0) {
            tt.cancel();
        }
    }
}, t);