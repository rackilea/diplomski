class MyJob implements StatefulJob {

    public MyJob() {
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        int count = dataMap.getIntValue("count");

        // allow 5 retries
        if(count >= 5){
            JobExecutionException e = new JobExecutionException("Retries exceeded");
            //make sure it doesn't run again
            e.setUnscheduleAllTriggers(true);
            throw e;
        }


        try{
            //connect to other application etc

            //reset counter back to 0
            dataMap.putAsString("count", 0);
        }
        catch(Exception e){
            count++;
            dataMap.putAsString("count", count);
            JobExecutionException e2 = new JobExecutionException(e);

            Thread.sleep(600000); //sleep for 10 mins

            //fire it again
            e2.setRefireImmediately(true);
            throw e2;
        }
    }
}