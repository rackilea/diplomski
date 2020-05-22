PriorityQueue<Integer> PQ= new PriorityQueue<Integer>();
    PQ.add(3);
    PQ.add(4);
    PriorityQueue<Integer> PQCopy = new PriorityQueue<>(PQ);
    PQCopy.remove();

    for(Integer i: PQ)
    {
        System.out.println(i);
    }

    for(Integer i: PQCopy)
    {
        System.out.println(i);
    }