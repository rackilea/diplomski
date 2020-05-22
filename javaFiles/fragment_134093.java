public class `Initializer` {
    private List<Handler> handlers = new ArrayList<>();
    ...
    @PostConstruct
    public void postInit() {
       for (Type type : Type.values()){
          Handler handler = type.createHandler();
          if (handler != null){
             handlers.add(handler);
          }
       }                      
    }
    ...

    @PreDestroy
    public void shutdown() {
        for(Handler handler : handlers) {
            handler.shutdown();
        }
    }
 }