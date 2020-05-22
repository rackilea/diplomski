@Override
public void update(Observable o, Object arg) {
    Platform.runLater(new Runnable() {
       public void run() {             
           new anotherApp().start(new Stage());
       }
    });
}