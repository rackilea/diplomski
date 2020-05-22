public class MyActualJob extends BaseJob {
    public static final int PRIORITY = 1;

    public MyActualJob() {
        super(new Params(PRIORITY).requireNetwork().persist());
    }

    @Override
    public void onAdded() {
        // job added to queue
    }

    @Override
    public void onRun() throws Throwable {
        // do the work
        // service will be injected into BaseJob, so you can use it here
        final Call<User> call = service.getUser();
        call.execute();
    }

    @Override
    protected void onCancel() {
        // clean up
    }
}