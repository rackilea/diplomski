private final Object lock = new Object();
   private boolean isServiceInitialized;
   private ApplicationContext context; 

   private ApplicationContext context() {
       synchronized(lock) {
            if (!isServiceInitialized || context == null) {
                initializeTouchPointService();
                condition = true;
            }
            return context;
        }
   }

   public Object getBean(String beanName) {
        return context().getBean(beanName);
   }