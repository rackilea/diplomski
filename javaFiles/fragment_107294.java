import java.lang.Thread.State;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Michael Jones
 * @description Slave Thread
 */
public class action implements Runnable {

    private String event = "";
    private AtomicInteger state;

    /**
     * The constructor (this represents the current instance of a thread).
     * 
     * @param event
     * @param state
     */
    public action(String event, AtomicInteger state) {
        this.event = event; // update this instance of event
        this.state = state; // update this instance of state
    } // constructor

    /**
     * This method will be called after YourThreadName.Start();
     */
    @Override
    public void run() {
        if (this.event == "resume") {
            this.OnResume(); // call resume
        } else {
            this.OnPause(); // call pause
        }
    } // close Runnable run() method

    /**
     * The resume function Use the auto lock from synchronized
     */
    public synchronized void OnResume() {
        System.out.println("[OnResume] The state was.." + this.getAtomicState()
                + " // Thread: " + Thread.currentThread().getId());
        this.setAtomicState(2); // change the state
        System.out.println("[OnResume] The state is.." + this.getAtomicState()
                + " // Thread: " + Thread.currentThread().getId());
    } // close function

    /**
     * The pause function Use the auto lock from synchronized
     */
    public synchronized void OnPause() {
        System.out.println("[OnPause] The state was.." + this.getAtomicState()
                + " // Thread: " + Thread.currentThread().getId());
        this.setAtomicState(1); // change the state
        System.out.println("[OnPause] The state is.." + this.getAtomicState()
                + " // Thread: " + Thread.currentThread().getId());
    } // close function

    /**
     * Get the atomic integer from memory
     * 
     * @return Integer
     */
    private Integer getAtomicState() {
        return state.intValue();
    }// close function

    /**
     * Update or Create a new atomic integer
     * 
     * @param value
     */
    private void setAtomicState(Integer value) {
        if (this.state == null) {
            state = new AtomicInteger(value);
        } else
            state.set(value);
    } // close function

} // close the class