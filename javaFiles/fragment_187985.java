try {
        while (true) {
            // produce outside of synchronized
            Integer product = 1;

            // BEGIN put atomic
            synchronized (buffer) {
                while (buffer.remainingCapacity() == 0) {
                    buffer.wait();
                }
                buffer.add(product);
                buffer.notifyAll();
                System.out.println("Producer active with remaining capacity: "
                        + buffer.remainingCapacity());
            }
            // END put atomic

            // consumer should likewise consume the product outside
            // of the synchronized block
        }
    } catch (InterruptedException e) {
        e.printStackTrace();
    }