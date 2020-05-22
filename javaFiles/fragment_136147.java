val registry = 
    RetryRegistry.of(RetryConfig.custom().maxAttempts(4).build())
  val retry = registry.retry("my")

  Retry.decorateCheckedFunction(retry, (x: Int) => {
    println(s"woohoo $x")
    throw new ConnectException("Test")
    42
  }).apply(1)