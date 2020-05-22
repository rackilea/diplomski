public static String execute(final String executable,
            final String workingdir, final String input) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Callable<String> task = new Callable<String>() {
            public String call() throws Exception {
                // Execution in another thread.
                String line = "";
                try {
                    Command command = new Command(input, executable, "-a",
                            workingdir + "ndrg.gg");
                    command.execute();
                    line = command.getErrorOutput();
                    if (line.contains("1 records processed")) {
                        line = command.getOutput();
                        if (line.length() > input.length() + 1) {
                            line = command.getOutput().substring(
                                    input.length() + 1);
                        } else {
                            line = "ERROR:1- " + line;
                        }
                    } else {
                        line = "ERROR: " + line;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    line = "ERROR: " + ex.getMessage();
                }
                return line;
            }
        };
        Future<String> future = executor.submit(task);
        String response = "";
        try {
            // Wait 10s for response.
            response = future.get(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            // Write something meaningful
            response = "InterruptedException"
        } catch (ExecutionException e) {
            e.printStackTrace();
            // Write something meaningful
            response = "ExecutionException"
        } catch (TimeoutException e) {
            e.printStackTrace();
            // Do something if response is not ready within 10s.
            response = "TimeoutException"
        }
    return response;
    }