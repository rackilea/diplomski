List<Future<Integer>> futures = new ArrayList<>();
futures.add(executor.submit(() -> doTaskWith(100));
futures.add(executor.submit(() -> doTaskWith(200));

for(future: futures) {
   future.get(); //Uh oh, blocking here!
}