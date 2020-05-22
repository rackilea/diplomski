List<Future<?>> futures = container.stream()
    .map(d -> scaleAndUpload()) // now you have Runnables
    .map(es::submit) // now they're Futures
    .collect(Collectors.toList());
return futures.stream()
    .map(Future::get)  // collect the link when the future is finished
    .collect(Collectors.toList()); // create a list of them