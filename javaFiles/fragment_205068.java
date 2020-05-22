// Create an EvictingQueue with a max size of 5
Collection<Integer> collection = EvictingQueue.create(5);
// Add 5 elements to the queue
collection.addAll(Arrays.asList(1, 2, 3, 4, 5));
System.out.println(collection);
// Add one more element
collection.add(6);
System.out.println(collection);