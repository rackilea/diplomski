@GetMapping("/test-async")
public Callable<String> getFoobar() {
   return () -> {
      Thread.sleep(12000); //this will cause a timeout
      return "foobar";
   };
}