val ecForBlockingMemcachedStuff = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(100)) // whatever number you think is appropriate
// i create a separate ec for each blocking client/resource/api i use

Future {
    cache.get(key) //synchronous blocking call
}(ecForBlockingMemcachedStuff) // or mark the execution context implicit. I like to mention it explicitly.