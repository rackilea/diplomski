public void run() {
    // Your code here, there is probably a loop
    while (someCondition) {
        // Loop work
        synchronized(this) {
            if (pause) {
                pause = false;
                wait();
            }
        }
    }
}

public synchronized void pause() {
    pause = true;
}

public synchronized void go() {
    notify();
}