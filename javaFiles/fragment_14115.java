public class MWT extends Canvas implements Runnable {
    // change the constructor so it doesn't make a new JFrame
    // change the constructor so it doesn't add a new instance to the JFrame
    // leave the rest unchanged
}

public class ThreadedGraphicsDemo extends JFrame {
    private MWT mwt;

    public ThreadedGraphicsDemo(MWT mwt) {
        this.mwt = mwt;

        add(mwt);
        // set exit behavior, size, pack, visible etc
    }
}

public class Demo {
    public static void main(String[] args) {
        MWT mwt = new MWT();
        ThreadedGraphicsDemo tgd = new tgd(mwt);
    }
}