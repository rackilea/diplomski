public static void main(String[] args) {
         LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue();
         private MyCompletionService[] executors = ... {} ;

         while(true){
            System.out.println(String.format("%s: Woohoo %s is done!", System.currentTimeMillis(), queue.take()));
         }
   }