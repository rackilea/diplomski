public List<User> getAllUsers(List<String> ids) {

    List<Future<UserReport>> futures = new ArrayList<>();
    ExecutorService executor = Executors.newFixedThreadPool(10);

    int counterU = 0;
    for (String id : ids) {
        Callable<UserReport> task = () -> {
            return runRequest(id);
        };
        futures.add(executor.submit(task));
        LOGGER.info("Added Task {} for UserId {}.", counterH++, id);
    }

    List<User> toReturn = new ArrayList<>();

    for (Future<UserReport> future : futures) {
        try {
            UserReport report = future.get();

            if (report.getUsers() != null) {
                User temp = report.getUsers().get(0);
                LOGGER.info("Got details for User {}.", temp.getId());
                toReturn.add(temp);
                insertUserToDB(temp);
            }

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    executor.shutdown();
    return toReturn;
}