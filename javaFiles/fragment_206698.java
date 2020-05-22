if (lock == null) {

        obj = new NotificationPop();
        obj.proragramstatuswarning();
        Thread.sleep(6000);
        System.exit(0);
        channel.close();
        throw new RuntimeException("Only 1 instance can run");


    }