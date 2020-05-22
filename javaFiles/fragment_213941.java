t.headerFunction(Constants.MONITORING_ID, 
     new Function<Message<Object>, Object>() {
           Object apply(Message<Object> message) {
               return UUID.randomUUID();
           }
     }
);