//Get the nodes from heroku, and block until we get them
final CountDownLatch latch = new CountDownLatch(1);
Thread thread = new Thread(new Runnable()
{
    @Override
    public void run()
    {
        try
        {
            // Get the nodes from Heroku
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint("http://safe-hollows-9286.herokuapp.com")
                    .build();
            HerokuService herokuService = restAdapter.create(HerokuService.class);
            tempNodes = herokuService.nodes();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        latch.countDown();
    }
});
thread.start();
try
{
    latch.await();
}
catch (InterruptedException e)
{
    e.printStackTrace();
}