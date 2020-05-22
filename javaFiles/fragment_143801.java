public void myService(){    
final ExecutorService service = Executors.newSingleThreadExecutor();
        boolean timeoutFlag=true;
        FTPFile[] files=null;
        TimerTask st= new TimerTask(client);

        try {
            final Future<TimerTask> f =  (Future<TimerTask>) service.submit(st);
            f.get(6, TimeUnit.SECONDS) // give here the execution time in 6 seconds 
            System.out.println("count files:"+TimerTask.files.length);
            files=TimerTask.files;
        } catch (final TimeoutException e) {
            timeoutFlag=false;
            Print.logInfo("Timeout exception..");
            System.out.println("Timeout exception");
        } catch (final Exception e) {
            timeoutFlag=false;
            Print.logInfo("Timeout exception : "+e.getMessage());
            System.out.println("timeout exception "+e.getMessage() );
            throw new RuntimeException(e);
        } finally {
            service.shutdown();
        }
}