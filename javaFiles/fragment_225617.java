main(String[] args) {

  String[] inputs;
  Future<Result>[] results;

  for (int i = 0; i < inputs.length; i++) {
    results[i] = executor.submit(new Worker(inputs[i]);
  } 
  for (int i = 0; i < inputs.length; i++) {
    Result r = results[i].get();
    // do something with the result
  }
}