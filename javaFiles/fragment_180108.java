private static final Map<Integer, Boolean> threadIsDone = new HashMap<>();

public WorkThread(int[] vec, int id) {
    threadIsDone.put(id, false);
    ...
}