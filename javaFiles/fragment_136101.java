try {
   ....
} catch (PersistenceException e) {
  final Throwable cause = e.getCause();
  if (cause instanceof SQLSyntaxException) {
    // handle the exception
  }
}