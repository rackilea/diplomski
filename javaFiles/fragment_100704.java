synchronized(Restaurant.waitpersonsList) {
                try {
                    System.out.println("Waitperson" + this.waitPersonId + " is waiting...");
                    wait();
                    System.out.println("WaitPerson" + this.waitPersonId + " is attempting to get " + restaurant.order);
                }
                catch(InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }