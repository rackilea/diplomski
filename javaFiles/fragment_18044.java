boolean read() {   
   Future<Boolean> future = service.submit(() -> {
      // Do your calculations and return whatever is required
      return true;
   });

  // future.get() blocks current thread execution until Callable returns the result
  return future.get();
}