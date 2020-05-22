public class MyEvent<T extends MyHandler> extends SomeEvent<T> {
      public void executeHandlers() {   
        for (T handler : handler_list) {
            //Exception here!!
            handler.startEventAction(lvc_count);
        }
    }