private Set<RequestOrders> mRequests = new HashSet<>();
private Set<RequestOrders> backlog = new HashSet<>();

public void handleOrder(RequestOrders order) {
    synchronized (lock) {
        if (!mRequests.contains(order)) {
            final sOrder = saveOrderOnDB(order);
            backlog.add(sOrder);
            handleOrder(sOrder);
        }
    }
}

void notifyOrder(int type) {
    if (!mPause) {
        for (RequestOrders request : mRequests) { // Error here while iterating
            if (.....) {
                redirectOrders(request);
            } else if (....) {
                ......
                startService(.....);
            }
        }
        mRequests.addAll(backlog);
        backlog.clear();
    } else {
        .....
    }
}