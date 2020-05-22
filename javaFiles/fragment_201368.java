Handler m_handler;
Runnable m_handlerTask ; 
m_handler = new Handler(); 
m_handlerTask = new Runnable() 
{ 
@Override
public void run() {
  showDatabase.setTextColor(Color.WHITE); 
  m_handler.postDelayed(m_handlerTask, 500); 
 }
 };
 m_handlerTask.run();