import java.util.concurrent.atomic.AtomicInteger;
/**
 * @author Michael Jones
 * @description Main Thread
 */
public class start {
    private AtomicInteger state;
    private Thread p;
    private Thread r;
    /**
     * constructor
     * initialize the declared threads
     */
    public start(){
        //initialize the state
        this.state = new AtomicInteger(0);
        //initialize the threads r and p
        this.r = new Thread(new action("resume", state));
        this.p = new Thread(new action("pause", state));
    } //close constructor

    /**
     * Start the threads
     * @throws InterruptedException 
     */
    public void startThreads() throws InterruptedException{
        if(!this.r.isAlive()){
            r.start(); //start r
        }
        if(!this.p.isAlive()){
            Thread.sleep(1000); //wait a little (wait for r to update)...
            p.start(); //start p
        }
    } //close startThreads

    /**
     * This method starts the main thread
     * @param args
     */
    public static void main(String[] args) {
         //call the constructor of this class
        start s = new start();
        //try the code
        try {
            s.startThreads();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } //start the threads
    } //close main

} //close class start