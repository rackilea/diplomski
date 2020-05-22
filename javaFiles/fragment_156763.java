public void run() {
                try {
                    System.out.println("Thread"
                            + Thread.currentThread().getName()
                            + "Wait for the command");

                    cdOrder.await();
                    System.out.println("Thread"
                            + Thread.currentThread().getName()
                            + "received command");
                    Thread.sleep((long) (Math.random() * 10000));
                    System.out.println("Thread"
                            + Thread.currentThread().getName()
                            + "Feedback the results");
                    cdAnswer.countDown(); -- countdown on latch cdAnswer
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("To complete the order");
                    cdAnswer.countDown(); -- countdown on latch cdAnswer

                }
            }