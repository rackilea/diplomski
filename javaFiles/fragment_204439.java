try {
        this.getCommands();
        if (this.tasks.size() > 0)
            this.processTasks();
        if (!this.shutdown)
            Thread.sleep(ServiceSleepTime);
    }
    catch (InterruptedException e) {
        this.shutdown = true;
    }
    catch (Exception e) 
    {
        this.logException("serviceProcessThread", e);
    }