Task<List<User>> task = new Task<List<User>>() {
    @Override protected List<User> call() throws Exception {
        return userRepository.getAll(whereClause);
    }
});
task.setOnSucceeded(event -> userTable.getItems().setAll(task.getValue()));
task.setOnFailed(event -> task.getException().printStackTrace());
exec.execute(task);