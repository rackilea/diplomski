Runnable runnable = new Runnable() {
     void run() {
         expensiveMethod();
     }
};

// runnable's method is not executed since the method run is not called
// the runnable.run() invokes the expensiveMethod()