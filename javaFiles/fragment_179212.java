public class ActivityLogger{
     private String message;
     private Risk_Mgnt_Manager m; // ***** added

     public ActivityLogger(Risk_Mgnt_Manager m) {
       this.m = m; // ****** added
     }

    // this will perform different purposes once I can print to JTextArea
    public void logger(String log, int type, boolean execution){
    if (execution == true) {

                message = log;
    } 
            if (execution == false) {

                message = log;
    } 

            print();

}
    // calls method Alert in main class and passes the string correctly
    public void print(){
      // Risk_Mgnt_Manager m = new Risk_Mgnt_Manager();
      SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          m.Alert(message);
        }
      });
    }
}