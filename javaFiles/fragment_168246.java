List<Future<?>> futures = new ArrayList<>();
for ( Elem elem : elems ) {
  futures.add(elemManager.doSomething(elem));
}
for (Future<?> future : futures) {
  System.out.println(future.get());
}