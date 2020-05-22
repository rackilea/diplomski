class Whatever {
   private final ExecutorService service;
   Whatever() { this ( Executors.newSingleThreadExecutor() ); }

   Whatever(ExecutorService service) { this.service = service; }

   void foo() {
     service.submit ( ... whatever