new Thread(new Runnable()
    {
        public void run()
        {
            try
            {
              //your HTTP request code..      
            }
            catch (IOException e)
            {
                //Handle exceptions
                e.printStackTrace();
            }
        }
    }).start();