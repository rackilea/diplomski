public void execute(Callable<String> request) {
  try {
    System.out.println("result is " + request.call());
  } catch (Exception ex) {
    ex.printStackTrace();
  }
}