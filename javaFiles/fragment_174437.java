@Test
    public void test2() throws IOException {
        String dir = "/tmp/acc2tid2999928854413665054";
        int[] shardIds = new int[]{1, 2};
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int id : shardIds) {
            executorService.submit(
                    () -> {
                        try {
                            System.out.println(Files.readAllLines(Paths.get(dir, String.valueOf(id)), Charset.forName("UTF-8")));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS); //Wait up to 1 minute for the tasks to complete
    }