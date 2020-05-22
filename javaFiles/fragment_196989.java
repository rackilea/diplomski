List<Future> tasks = new ArrayList<Future>();
        ThreadPoolExecutor tpe = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        Process process = new Process();
        ProcessingJobMeta meta = process.getPJM();
        List<CuratedInput> cil = meta.getCuratedInputList();
        for (final CuratedInput ci : cil) {
            .....
        }

        tpe.shutdown();
        while (!tpe.isShutdown()) {

        }