public class JavaApp {

    private Observe observer;  private int counter = 0;

    JavaApp(Observe observer){//not null safe
        this.observer = observer;
    }

    void process() {
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override   public void run() {
                observer.update(counter >=100 ? 0 : ++counter);
            }
        }, 1000,1000);
    }

    public static void main(String[] args) {
        JavaFxApp view = new JavaFxApp(); //initialize JavaFx application
        JavaApp main = new JavaApp(view);

        Platform.startup(() -> {//launch JavaFx application 

            Stage stage = new Stage();
            try {
                view.start(stage);
            } catch (Exception ex) {ex.printStackTrace();}
        });

        main.process(); //run business process 
    }
}