class ManagedThreadPoolExecutor extends ThreadPoolExecutor {
      @Override
      protected void afterExecute(Runnable r, Throwable t) {
           if(t != null)
                setMaximumPoolSize(getMaximumPoolSize()-1);
           else
                setMaximumPoolSize(getMaximumPoolSize()+1);

      }
}