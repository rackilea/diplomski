Handler m_handler;
Runnable m_handlerTask ; 
m_handler = new Handler(); 
@Override
public void run() {
           // do something 
  m_handler.postDelayed(m_handlerTask, 1000);
 }
 };
 m_handlerTask.run();