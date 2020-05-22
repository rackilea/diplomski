MyRunnable implements Runnable {
     private String m_whatToDo;

     public MyRunnable(String whatToDo) {
           m_whatToDo = whatToDo;
     }


     public void Runnable run() {
          if ("x".equals(m_whatToDo) {
                 // code to do X
          } else if ( "y".equals(m_whatToDo) {
                 // code to do Y
          } else {
                 // some error handling
          }
     }
 }