public class Helper {
        private ExecutorService service;

        public String startService() {
           // ExecutorService service = Executors.newSingleThreadExecutor();
            service = Executors.newSingleThreadExecutor();
            service.submit(new  Runnable() {
                public void run() {
                    new Worker().startWork(callableTaskList);   
                }
            });
            return "started"
        }

    public void stopService() { 
        service.shutdownNow();
    }
}