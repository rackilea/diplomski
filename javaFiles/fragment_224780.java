try {
  connectionProvider.startTransaction();
  interceptedMethod.invoke();
  connectionProvider.commit();
} catch (Exception e) {
  connectionProvider.rollback();
}