public class YourClass {

    CustomClosableAction doOnClose;

    public YourClass(CustomClosableAction doOnClose) {
        this.doOnClose = doOnClose;
    }

    public void initialize() {
    }

    public void shutDown() {
        doOnClose.onClosing();
    }

    @FunctionalInterface
    interface CustomClosableAction {
        void onClosing();
    }

}


public final class YourClassFactory {

    private YourClass instance = null;

    public YourClass getYourClass() {
        YourClass.CustomClosableAction onClosing = () -> {
            instance = null;
        };

        if(instance == null) {
            YourClass yourClass = new YourClass(onClosing);
            yourClass.initialize();
        }

        return instance;
    }

}