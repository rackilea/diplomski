public class Worker {
        private ExecutorService service;
        private ExecutorService anotherService;

        public void startWork(List<CallableTask> callableTaskList) throws Exception {
            service=Executors.newFixedThreadPool(50);
            anotherService=Executors.newFixedThreadPool(50);

            for (List<CallableTask> partition : Iterables.partition(callableTaskList, 500)){
                checkInterruptStatus(); 


                // do some work here and then return
                List<Future<String>> futures=service.invokeAll(partition );
                for(Future<String> future: futures){
                    checkInterruptStatus();

                    anotherService.submit(new Task(future.get()));
                }
            }
        }

        private void checkInterruptStatus() throws InterruptedException {
            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedException();
            } 
        }

        public void stopService() {
            service.shutdownNow();
            anotherService.shutdownNow();
        }
    }