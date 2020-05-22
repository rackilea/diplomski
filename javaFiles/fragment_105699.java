public class DeleteMe {

    public static void main(String[] args) throws Exception {
        DeleteMe me = new DeleteMe();
        me.go();
    }

    public void go() throws Exception {
        final Mutable mutable = new Mutable();
        new Thread(new Runnable() {
            @Override
            public void run() {
                mutable.setT(57);
            }
        }).start();
        /** Main thread waits a bit to be sure that the custom Thread will start */
        Thread.sleep(2000);
        System.out.println(mutable.getT());
    }

    private class Mutable{
        public int t = 0;

        public int getT() {
            return t;
        }

        public void setT(int t) {
            this.t = t;
        }
    }
}