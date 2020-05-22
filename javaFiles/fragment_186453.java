private final AtomicInteger numOfRequests = new AtomicInteger(0);
public int getNumOfRequests() {
    return numOfRequests.get();
}
public void incrementNumOfRequests(int requests) {
   numOfRequests.addAndGet(requests);
}