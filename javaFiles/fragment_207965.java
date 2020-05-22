ExecutorService exec = ...;
List<SubsetCallable> callables = new LinkedList<SubsetCallable>();
for (X x : lx) {
    callables.append(new SubsetCallable(x));
}
List<Future<List<Integer>>> futures = exec.invokeAll(lc);
for (Future<List<Integer>> f : futures) {
    li.add(f.get());
}