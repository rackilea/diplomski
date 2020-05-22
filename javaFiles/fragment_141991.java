handler=new Handler();
            final Runnable r = new Runnable()
            {
                public void run() 
                {
                    //Write your code here

                    handler.postDelayed(this, 100);
                }
            };

            handler.postDelayed(r,100);