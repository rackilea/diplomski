final String hello = whereverItsComingFrom;
Runnable done = new Runnable()
    {
        public void run()
        {
            System.out.println(hello);
        }
    };