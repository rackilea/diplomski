ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(streamGobbler);

        int exitCode = process.waitFor();

        executor.shutdown();