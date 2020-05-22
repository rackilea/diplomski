CustomerQueue cQ = null;
    for (int i = 0; i < 10; i++) {
        CustomerQueue subQueue = new CustomerQueue(1, 0, false);
        cQ.enqueue(subQueue);
        System.out.println(subQueue.arrivalTime);
    }