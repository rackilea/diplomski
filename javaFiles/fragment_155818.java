class Bean2 {

      @Autowire
      private InventoryDisclosureBO idbo;   <-- Spring will inject a proxy here

      public void persist(InventoryDisclosureStatus data) {
           idbo.persist(data);     <-- now it will work via proxy
      }
...