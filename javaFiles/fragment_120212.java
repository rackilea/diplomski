List<DoesExpensiveProcessing> doInParallel = new ArrayList<DoesExpensiveProcessing>();
for (Map map : maps) {
   doInParallel.add(new DoesExpensiveProcessing(map.keySet()));
}

Set theResultingSet = new HashSet<String>();
List<Future<Set<String>>> futures = someExecutorService.invokeAll(doInParallel);
for (Future<Set<String>> f : futures) {
  theResultingSet.addAll(f.get());
}