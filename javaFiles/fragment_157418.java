public class class1 {

    // this logger will just use rootLogger
    private static Logger log = Logger.getLogger(Thread.currentThread().getName() + "." + class1.class.getName());
    static Worker W = null;
    static SomethingElse SE = null;

    public static void main(String args[]) {
        System.out.println("Hello");        
        log.info("Hello world");

        W = new Worker();
        W.start();

        SE = new SomethingElse();
        SE.start();        

        System.out.println("Byebye");
    }    
}