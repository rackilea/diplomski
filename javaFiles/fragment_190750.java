Handler m_handler;
 Runnable m_handlerTask ;
      m_handler = new Handler();
       m_handlerTask = new Runnable()
       {
           @Override 
           public void run() { 
              // do something
                m_handler.postDelayed(m_handlerTask, 1000);
                  // repeat some task every 1 second    

           }
      };
      m_handlerTask.run();