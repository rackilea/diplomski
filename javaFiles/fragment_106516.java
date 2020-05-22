class CTest implements Comparable<CTest> {
        public CTest(int v) {
            this.v = v;
        }
        Integer v;

        @Override
        public int compareTo(CTest o) {
            return this.v.compareTo(o.v);
        }
    }

    PriorityQueue<CTest> PQ= new PriorityQueue<CTest>();
    PQ.add(new CTest(3));
    PQ.add(new CTest(4));
    PriorityQueue<CTest> PQCopy = new PriorityQueue<>(PQ);
    PQCopy.iterator().next().v = new Integer(6);

    for(CTest i: PQ)
    {
        System.out.println(i.v);
    }

    for(CTest i: PQCopy)
    {
        System.out.println(i.v);
    }