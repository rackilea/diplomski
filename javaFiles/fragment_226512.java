@Override
    public void run() {
        String name = Thread.currentThread().getName();
        while (true) {

            synchronized (anotherLock) {
                while (queue.peek() == null) {
                    anotherLock.wait();
                }
            }

            synchronized (lock) {
                while (queue.peek() != null && !name.equals(String.valueOf(queue.peek().intValue() % 2 ))) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(queue.peek() != null) {
                    try {
                        System.out.println(name + ",consumed," + queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }
    }