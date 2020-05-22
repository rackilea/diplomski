Thread t1 = new Thread(new Runnable() {

                @Override
                public void run() {
                    demo.putValue(1, 10);

                }

            });
            t1.start();

            Thread t2 = new Thread(new Runnable() {

                @Override
                public void run() {
                    demo.putValue(1, 10);

                }

            });
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(demo.getMap().size());