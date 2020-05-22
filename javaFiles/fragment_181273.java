class Ishappy extends Thread {
    private volatile Integer num;
    private Thread main;
    private volatile boolean out = false;

    Ishappy(int i, Thread main) {
        this.main = main;
        num = i;
    }

    void Exit() {
        out = true;
    }

    @Override
    public void run() {
        while(!out) {   /// <- here was the problem
            if(num.intValue() == 1) { // since this condition will break out
                main.interrupt();     // of the loop, you do not need it in the
                break;                // while condition
            }

            String s = num.toString();
            int temp = 0;
            for(int i = 0 ; i < s.length(); i++) {
                int x = Integer.parseInt(s.substring(i, i+1));
                temp += x*x;
            }
            num = temp;
        }
    }
}