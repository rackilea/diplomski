RetryPolicy retryPolicy = new RetryPolicy()
  .abortOn(SQLException.class)
  .retryOn(NullPointerException.class)
  .withMaxRetries(50);

Connection connection = Failsafe.with(retryPolicy).run(() -> {
  Item item = getItemById(id);
  NewData data = ProcessItem(item);
  SaveNewData(data);
});