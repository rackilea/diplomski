FutureTask<Integer> dialogTask = new FutureTask<Integer>(new Callable<Integer>() {
  @Override public Integer call() {
    return JOptionPane.showConfirmDialog(...);
  }
});
SwingUtilities.invokeLater(dialogTask);
int result = dialogTask.get();