public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService orintMapExe = Executors.newFixedThreadPool(4);
        List<Future<List<Integer>>> futures = new ArrayList<>();

        futures.add(orintMapExe.submit(new OrintMapRun(10, 10)));
        futures.add(orintMapExe.submit(new OrintMapRun(20, 20)));
        futures.add(orintMapExe.submit(new OrintMapRun(30, 30)));
        futures.add(orintMapExe.submit(new OrintMapRun(40, 40)));

        orintMapExe.shutdown();
        try {
            orintMapExe.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(Future<List<Integer>> future : futures) {
            List<Integer> result = future.get();
            System.out.println(result);
        }
    }