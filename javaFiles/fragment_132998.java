class Reader implements Runnable {
        @Override
        public void run() {
            synchronized (this) {
                System.out.println("waiting for condition");
                while (!condition) {}
                System.out.println("condition is true");
            }
        }
    }


class Writer implements Runnable {
        @Override
        public void run() {
            synchronized (this) {
                System.out.println("condition is set to true");
                condition = true;
            }
        }
    }