new MyRunnable() {
       @Override
       public void run() {
           for (int i = 0; i < inbuiltProxyPojoArrayList.size(); i++) {
                 if (continueRunning) {
                        //someWork
                 } else {
                    MyLogger.log(MyLogger.LOG_TYPE.DEBUG, "ThreadPool: Pool Thread Interrupted (closing down)");
                     break;
                 }
            }
            System.out.println("ThreadPool: Test complete");
         }
     };