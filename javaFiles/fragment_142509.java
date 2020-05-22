CustomerQueue cQ = null;
    for (int i = 0; i < 10; i++) {
        cQ = new CustomerQueue(1, 0, false);
        cQ.enqueue(cQ);
        System.out.println(cQ.arrivalTime);
    }