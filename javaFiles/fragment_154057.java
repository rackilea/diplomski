new Thread(new Runnable() {

    @Override
    public void run() {
        try {
        long before, sleepDuration, operationTime;
        for(int i=0;i<100;i++) {
            before = System.currentTimeMillis();
            // do your operations
            operationTime = (long)(1500*Math.random());
            System.out.print("Doing operations for "+operationTime+"ms\t");
            Thread.sleep(operationTime);

            // sleep for up to 1000ms
            sleepDuration = Math.min(1000, Math.max(1000 - (System.currentTimeMillis() - before), 0));
            Thread.sleep(sleepDuration);
            System.out.println("wait\t"+sleepDuration+"ms =\telapsed " + (operationTime+sleepDuration) + (operationTime > 1000 ? "<" : ""));
        }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}).start();