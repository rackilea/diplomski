List<Future<String>> taskFutureList = new LinkedList<Future<String>>();
 while ((line = br.readLine()) != null) {
    try {
        Subscriber subscriber = createSubscriber(subscription, line);
        cache.add(subscriber);
        if (cache.size() >= batchSize) {
                    taskFutureList.add(executorService.submit(createCallable(cache,subscription.getSubscriptionId())));
            List<Subscriber> cache = new ArrayList<>();
        }
     } catch (InvalidSubscriberDataException e) {
        invalidRows.add(line + ":" + e.getMessage());
        invalidCount++;
    }
}
//submit last batch that could be < batchSize
if(!cache.isEmpty()){ 
           taskFutureList.add(executorService.submit(createCallable(cache,subscription.getSubscriptionId())));
}