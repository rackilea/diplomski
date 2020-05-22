public class ThreadDictionarySearch extends Thread {

    // the actual dictionary
    private String dictionary;
    private Results results;

    public ThreadDictionarySearch(Results results, String dictionary) {
        this.dictionary = dictionary;
        this.results = results;
    }

    @Override
    public void run() {

        for (int i = 0; i < 4; i++) {
            // search dictionary;
            results.addResult("result of " + dictionary);
            System.out.println("adding result from " + dictionary);
        }

        results.oneDictionaryFinished();
    }

}