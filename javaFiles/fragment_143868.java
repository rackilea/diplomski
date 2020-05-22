void waitMethod() {
    wait(); // throws IllegalMonitorStateException  
}

void notifyMethod() {
    notify(); // throws IllegalMonitorStateException  
}