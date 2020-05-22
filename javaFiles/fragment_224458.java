static int a;
static Object o = new Object();
static boolean cont = true;

public void adder() {
    synchronized( o ) {
        if (cont) {
            MainClass.a++;
            System.out.println( MainClass.a );
            cont = (MainClass.a < 65535);
        }
    }
}

public void run() {
    while(MainClass.cont) {
        adder();
    }
}