@HystrixCommand(
  commandProperties = { 
    @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"), 
    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "50000")  
}, fallbackMethod = "fallbackActivityCall")
public Optional<ResponseActivityValue> callForActivity() {
 ....
}