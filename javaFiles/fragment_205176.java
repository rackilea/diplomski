// Schedule a once-a-week task at 8am on Sunday.        
    constituentScheduler.schedule("0 8 * * 7", new Runnable() {
        public void run() {
            Log.i(CLASS_NAME, "ConstituentScraper Schedule");

            es.submit(new ConstituentScraper());
        }
    });


    //scheduler.schedule("28 7 * * 1-5 | * 18 * * 1-5 ", new Runnable() {
    summaryScheduler.schedule("0 7 * * 1-5 |0 18 * * 1-5 ", new Runnable() {
        public void run() {
            Log.i(CLASS_NAME, "SummaryScraper Schedule");

            // TODO only put in queue if a working day
            es.submit(new SummaryScraper());
        }
    });