class PollingThread implements Runnable {
            @SuppressWarnings("unchecked")
            public void run(){
                Thread.currentThread().setName("MyPollingThread");
                while (!Thread.interrupted()) {
                    try {
                        synchronized (incomingList) {
                            if (incomingList.size() == 0) {
                                // incoming is empty, wait for some time
                            } else {
                                //clear the original
                                list = (LinkedHashSet<UUID>) 
                                        incomingList.clone();
                                incomingList.clear();
                            }
                        }

                        if (list != null && list.size() > 0) {
                            processJobs(list);
                        }
                        // Sleep for some time
                        try {
                            Thread.sleep(seconds * 1000);
                        } catch (InterruptedException e) {
                            //ignore
                        }
                    } catch (Throwable e) {
                        //ignore                    
                    }
                }
           }
    }