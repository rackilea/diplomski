static Runnable[] methods = new Runnable[10];

public static void main(String[] args) throws Exception {
    methods[0] = new Runnable() {
        @Override
        public void run() {
            System.out.println("method-0");
        }
    };
    methods[1] = new Runnable() {
        @Override
        public void run() {
            System.out.println("method-1");
        }
    };
    ...
    methods[1].run();
}