stop();

            try {
                //The thread used to play() the sound
                soundPlayThread.join();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }


            //Manually run the garbage collection and yield threads
            System.gc();
            Thread.yield();