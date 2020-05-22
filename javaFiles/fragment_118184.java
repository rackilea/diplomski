public class Controller {
    private Main application;
    private Scene scene;

    public void configure(final Main application, final Scene scene) {
        this.application = application;
        this.scene = scene;
    }

    public void show() {
        application.show(scene);
    }

    public void goToScreen2() {
        application.controller2.show();
    }

    public void goToScreen1() {
        application.controller1.show();
    }
}