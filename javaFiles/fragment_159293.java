ExecutorService service = Executors.newFixedThreadPool(8);
...
...

List<Callable> tasks = allListeners.stream().map(l->{ l.accept(event); return l;}).collect(Collectors.toList());

service.invokeAll(tasks);