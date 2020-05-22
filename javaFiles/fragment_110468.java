public void startThreadDeadlock() throws Exception
    {
        Future <String> wholePage = exec.submit(new RenderPageTask());
        System.out.println("Content of whole page is " + wholePage.get());
    }
    public static void main(String[] st)throws Exception
    {
        ThreadDeadLock tdl = new ThreadDeadLock();
        tdl.startThreadDeadLock();
    }