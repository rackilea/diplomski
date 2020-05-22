class XThread implements Runnable{

        private static Thread rT = null;
        private XThread()
        {}
        public static void terminateThread()
        {
            rT = null;
        }

        public static Thread getInstance()
        {
            if(rT==null)
            {
                rT = new Thread(new XThread());
            }
            return rT;
        }

        public void run()
        {
         //whatever functionality you want to add
        }
    }