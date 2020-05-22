while (!(mDiffQueue.isEmpty()  && mDone)) {
   // poll returns null if nothing is added in the queue for 0.1 second.
   Diff diff = mDiffQueue.poll(0.1, TimeUnit.SECONDS); 
   if (diff != null)
      process(diff);
}