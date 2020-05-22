public static void main(String[] args) throws Exception {

    Results results = new Results();

    ThreadDictionarySearch threadA = new ThreadDictionarySearch(results, "dictionary A");
    ThreadDictionarySearch threadB = new ThreadDictionarySearch(results, "dictionary B");
    ThreadDictionarySearch threadC = new ThreadDictionarySearch(results, "dictionary C");
    ThreadDictionarySearch threadD = new ThreadDictionarySearch(results, "dictionary D");

    threadA.start();
    threadB.start();
    threadC.start();
    threadD.start();

    if (results.isReady())
    // it stays here until all dictionaries are searched
    // because in "Results" it's told to wait() while not finished;

for (String string : results.getAllResults()) {
        System.out.println("RESULT: " + string);
    }