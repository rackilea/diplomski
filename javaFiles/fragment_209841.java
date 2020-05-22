public class Controller {
    public Controller(Model model, View view) {
        view.addViewControlListener(new ViewControlListener(model, view));
        ...
        Timer timer = new Timer(model, view);
        timer.start();
    }
}