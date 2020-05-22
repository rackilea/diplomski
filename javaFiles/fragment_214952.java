while (status.get() == RUNNING) {                
        try {
            execute();      //<-- very intensive 
            if (!status.compareAndSet(RUNNING, IDLE))
                break;
        } catch (Exception e) {
            logger.info("An exception occured in thread with ID : " + id);
            e.printStackTrace();
        } finally {
            try {
                Thread.sleep(DYNAMIC_VALUE);
            } catch (InterruptedException e) {}
            if (!status.compareAndSet(IDLE, RUNNING))
                break;
        }
    }