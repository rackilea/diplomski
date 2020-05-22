void run() {
    Runnable tmp = this.myRunnable;  // Assume JIT make this a register variable.
    this.myRunnable = null;          // Release for GC.
    if(tmp != null) {
        tmp.run();         // If the code inside tmp.run() overwrites the register, GC can occur.
        System.out.println("Executed runnable: "+tmp.hashCode());
        }
    }