try {
  callback.onDeleteSuccess(future.get());
} catch (InterruptedException | ExecutionException e) {
  Timber.e(e);
  throw e.getCause(); //<--- throw the unwrapped exception
}