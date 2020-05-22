public class LogListener implements ModelListener {

 public void execute(Model model) {
   // Do my logging here
 }
}

Model model = new Model();  
model.addListener(new LogListener());