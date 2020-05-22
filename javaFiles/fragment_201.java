public class Results {

    private int nrOfDictionaries = 4; //

    private ArrayList<String> results = new ArrayList<String>();

    public void prepare() {
        nrOfDictionaries = 4;
        results = new ArrayList<String>();
    }

    public synchronized void oneDictionaryFinished() {
        nrOfDictionaries--;
        System.out.println("one dictionary finished");
        notifyAll();
    }

    public synchronized boolean isReady() throws InterruptedException {

        while (nrOfDictionaries != 0) {
            wait();
        }

        return true;
    }

    public synchronized void addResult(String result) {
        results.add(result);
    }

    public ArrayList<String> getAllResults() {
        return results;
    }
}