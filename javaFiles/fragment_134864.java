resetSlap = new Thread()
{
        public void run()
        {           
            while(true)
            {
                try 
                {
                    Thread.sleep(500);
                    GameWindow.post(new Runnable()
                    {
                        public void run()
                        {                           
                            GameWindow.setImageBitmap(images[0]);
                            GameWindow.postInvalidate();
                        }
                });
                } catch (InterruptedException e)
                {                               
                    e.printStackTrace();
                }                                   
            }
        }
    };