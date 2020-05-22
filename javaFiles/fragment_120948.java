public class TaskForceView extends JPanel implements Observer{
     public TaskForceView(Observable observable){
         ...  
         observable.addObserver(this);
     }
}