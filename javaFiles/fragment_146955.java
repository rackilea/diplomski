class MyJob implements Job {

    public MyJob() {
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {

        try{
            //connect to other application etc
        }
        catch(Exception e){

            Thread.sleep(600000); //sleep for 10 mins

            JobExecutionException e2 = new JobExecutionException(e);
            //fire it again
            e2.setRefireImmediately(true);
            throw e2;
        }
    }
}