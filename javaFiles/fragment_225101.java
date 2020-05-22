public class DashboardController implements Initializable {
 @Override
    public void initialize(URL url, ResourceBundle rb) {
        myTask = new MyTask();
         myTaskThread = new Thread(myTask);
         myTaskThread.start();


    } 
}