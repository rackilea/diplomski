private enum State {
   Running,
   Cancel
}

private final Map<String, State> state = Collections.synchronizedMap(new HashMap<>());
private final ExecutorService executor = Executors.newCachedThreadPool();

@GetMapping("/cancelThread/{id}")
public Map<String, Object> testThread(@PathVariable String id) {
    state.computeIfPresent(id, (k, v) -> State.Cancel);
}

@GetMapping("/testThread")
public Map<String, Object> testThread(HttpServletRequest request) {
    String id = java.util.UUID.randomUUID().toString()
    state.put(id, State.Running);

    executor.submit(() -> doWork(id));

    Map<String, Object> response = new HashMap<>();
    response.put("transactionId", id);
    return response;
}

private void doWork(String id) {
    executor.submit(() -); 

    try {
        for (int i = 0; i < 100000; i++) {
          if (state.get(id) == State.Cancel) {
              break;
          }

          System.out.println(i);
        }
    } finally {
        state.remove(id);
    }
}