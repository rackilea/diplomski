public void run() {
    while (index < 99) {
        synchronized (lock) {                    
            // double-check for threads that made it here
            // before #index got incremented to 99 by the thread that
            // made the final increment
            if (index < 99) {
                System.out.println(index);
                index++;
            }
        }
    }
}