invokeLater = new Thread(new Runnable() {

            @Override
            public void run() {        
              //Fetching records from Service
                try 
                {   
                    // database call here
                    if(showAnimation.isAlive())
                    {
                        showAnimation.interrupt();
                    }

                } 
                        }
             });