class LowPriorityThreadFactory implements ThreadFactory
{
   public Thread newThread(Runnable r) {
     Tread t = new Thread(r);
     t.setPriority(MIN_PRIORITY);
     return t;
   }
}