ExecutorService executorService = Executors.newFixedThreadPool(20);

for (int i = 0; i < 500; i++) {

        SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
                @Override
                protected Boolean doInBackground() throws Exception {

                        System.out.println("One SwingWorker just ran!");
                        return true;
                }


                protected void done() {

                        boolean status;
                        try {

                                status = get();

                        } catch (InterruptedException e) {
                        // This is thrown if the thread's interrupted.
                        } catch (ExecutionException e) {
                        // This is thrown if we throw an exception
                        // from doInBackground.
                        }
                }

        };


        executorService.submit(worker);
}