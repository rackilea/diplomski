public class StreamTask implements Runnable {

    private final Set<String> allSymbolSet;
    private final PriorityBlockingQueue<String> priorityBlocking = new PriorityBlockingQueue<String>();

    public StreamTask() {
         String[] symbols = {"USBC", "TCSD", "PCLJ"};
         //use a thread safe set, for example based on ConcurrentHashMap
         allSymbolSet = Collections.newSetFromMap(new ConcurrentHashMap<String, Boolean> ());
         Collections.addAll(allSymbolSet, symbols);
    }

    public void addSymbols(String str) {
        if (str != null) {
            priorityBlocking.add(str);
        }
    }

    public Set<String> getSymbols() {
        return new HashSet<> (allSymbolSet); //return a copy
    }

    public void run() {
        while (true) {
            try {
                allSymbolSet.add(priorityBlocking.take());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}