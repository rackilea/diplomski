class CrawlingService extends AbstractScheduledService {

    @Override
    protected void runOneIteration() throws Exception {
        //run this alot
    }

    @Override
    protected void startUp() throws Exception {
        //anything you need to step up
    }

    @Override
    protected void shutDown() throws Exception {
        //anything you need to tear down
    }


    @Override
    protected Scheduler scheduler() {
        return new CustomScheduler() {
            @Override
            protected Schedule getNextSchedule() throws Exception {
                long a = 1000; //number you can randomize to your heart's content
                return new Schedule(a, TimeUnit.MILLISECONDS);
            }
        };
    }
}