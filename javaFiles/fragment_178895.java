class FooRunner{

     ExecutorService service = Executors.newSingleThreadExecutor();

     //where RunnableFoo extends Foo and implements Runnable
        public void insertThis(RunnableFoo f) throws InterruptedException{ Run
            service.submit(f);
        }
        public void stop(){
            service.shutdown();
        }

    }