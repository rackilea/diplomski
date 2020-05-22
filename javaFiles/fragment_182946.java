final ExecutorService e = 
    Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

for (Page page : book) {
    e.submit( new Runnable() {
              //http request to get page and put into concurrent data structure}
}