public class TestLambda {
    static int count = 0;
    public static void main(String[] args) {
        // lambda not going to work
        //Runnable foo = () -> { if (count < 5) { call(foo); } };
        // nor
        //Runnable foo = () -> { if (count < 5) { call(this); } };

        // using old way of anonymous inner class will work
        Runnable foo = new Runnable() {
            @Override public void run() {
                if (count < 5) {
                    call(this);
                }
            }
        };

        foo.run();
    }

    public static void call(Runnable action) {
        count++;
        System.out.println("in call " + count);
        action.run();
    }
}