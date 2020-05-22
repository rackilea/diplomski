public synchronized void put(int value) {
        if(process <= 500) {
            process+=value;
        } else {
            //while (process >= 1000) {
                start = System.currentTimeMillis();
                try {
                    wait();
                } catch (InterruptedException e) {
                }
                end = System.currentTimeMillis();
                wait = end - start;
                count++;
                request += wait;
                System.out.println("Application Request Wait Time: " + time.format(wait));
                process += value;
                contents = value;               
            //}
        }
        notifyAll();
    }