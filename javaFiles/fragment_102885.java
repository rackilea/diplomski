public class StreamTask {

    private final Set<String> allSymbolSet;

    public StreamTask() {
         String[] symbols = {"USBC", "TCSD", "PCLJ"};
         //use a thread safe set, for example based on ConcurrentHashMap
         allSymbolSet = Collections.newSetFromMap(new ConcurrentHashMap<String, Boolean> ());
         Collections.addAll(allSymbolSet, symbols);
    }

    public void addSymbols(String str) {
        if (str != null) {
            allSymbolSet.add(str);
        }
    }

    public Set<String> getSymbols() {
        return new HashSet<> (allSymbolSet); //return a copy
    }
}