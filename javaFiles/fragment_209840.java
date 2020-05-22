public class Timer extends Thread {

    private Model model;
    private View view;

    public Timer(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        while(true) { //could be better
            if(model.isActive()) {
                model.decLeftTime();
                view.repaint();
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}