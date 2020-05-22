sender.addListener(new ListenerInterface()
   {
      public void callback(Object arg)
      {
         handlerFunction(arg);
      }
   });