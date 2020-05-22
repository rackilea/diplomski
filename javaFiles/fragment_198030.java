public class Controller {
     //...

     public void updateUIText(String text){
           SwingUtilities.invokeLater(new Runnable() {
              public void run() {
                mainWindow.setMyLabelText("Hello");
              }
           });
     }
}