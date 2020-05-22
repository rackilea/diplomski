abstract class UI {
    private SplashScreen splash;

    public UI(SplashScreen splash) {
        this.splash = splash;
    }

    public void start() {
        splash.start();
        init();
        splash.end();
    }

    public abstract void init();
}