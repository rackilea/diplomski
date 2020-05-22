class SearchTask implements Callable<Integer> {
     private int localCounter = 0;
     private int start; // start index of search
     private int end;
     private List<String> words;
     private String token;

     public SearchTask(int start, int end, List<String> words, String token) {
         this.start = start;
         this.end = end;
         this.words = words;
         this.token = token;
     }

     public Integer call() {
         for(int i = start; i < end; i++) {
              if(words.get(i).equals(token)) localCounter++;
         }
         return localCounter;
     }        
}

// meanwhile in main :)

List<String> words = new ArrayList<String>();
// populate words 
// let's assume you have 30000 words

// create tasks
List<Callable> tasks = new ArrayList<Callable>();
tasks.add(new SearchTask(0, 10000, words, "John"));
tasks.add(new SearchTask(10000, 20000, words, "John"));
tasks.add(new SearchTask(20000, 30000, words, "John"));

// create thread pool and start tasks
ExecutorService exec = Executors.newFixedThreadPool(3);
List<Future> results = exec.invokeAll(tasks);

// wait for tasks to finish and collect results
int counter = 0;
for(Future f: results) {
    counter += f.get();
}