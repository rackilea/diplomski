PriorityBlockingQueue<Integer> pq = new PriorityBlockingQueue<>();
pq.add(5);
pq.add(8);
pq.add(3);

System.out.println("-- Try 1 --");
pq.stream().forEach(System.out::println);

System.out.println("-- Try 2 --");
IntStream.range(0, pq.size()).map(i -> pq.poll()).forEach(System.out::println);