class SearchTask implements Runnable {
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

     public void run() {
         for(int i = start; i < end; i++) {
              if(words.get(i).equals(token)) localCounter++;
         }
     }

     public int getCounter() { return localCounter; }
}

// meanwhile in main :)

List<String> words = new ArrayList<String>();
// populate words 
// let's assume you have 30000 words

// create tasks
SearchTask task1 = new SearchTask(0, 10000, words, "John");
SearchTask task2 = new SearchTask(10000, 20000, words, "John");
SearchTask task3 = new SearchTask(20000, 30000, words, "John");

// create threads for each task
Thread t1 = new Thread(task1);
Thread t2 = new Thread(task2);
Thread t3 = new Thread(task3);

// start threads
t1.start();
t2.start();
t3.start();

// wait for threads to finish
t1.join();
t2.join();
t3.join();

// collect results
int counter = 0;
counter += task1.getCounter();
counter += task2.getCounter();
counter += task3.getCounter();