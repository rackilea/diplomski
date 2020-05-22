Thread t1 = new Thread(() -> {
    while (count < max) {
        synchronized (lock) {
            if (count % 2 == 0) {
                System.out.println("In Even Thread " + count);
                count++;
                lock.notifyAll();
            } else {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
});

Thread t2 = new Thread(() -> {
    while (count < max) {
        synchronized (lock) {
            if (count % 2 != 0) {
                System.out.println("In Odd Thread " + count);
                count++;
                lock.notifyAll();
            } else {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
});