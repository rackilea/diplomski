class ThreadTask implements Runnable {

    private final AtomicInteger id;

    ThreadTask(AtomicInteger id) {
        this.id = id; //in your main thread: id = new AtomicInteger(minId);
    }

    @Override
    public void run() {
        dbConnection = getDBConnection();
        preparedStatement = dbConnection.prepareStatement(INSERT_SQL);

        preparedStatement.setString(1, String.valueOf(id.getAndIncrement()));
        preparedStatement.setString(2, ACCOUNT);

        preparedStatement.executeUpdate();
    }
}