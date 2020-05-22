public final class YourClassAdapter implements AutoCloseable {

    private YourClass instance = null;

    public YourClassAdapter(){

    }

    private YourClass getYourClass() {
        YourClass.CustomClosableAction onClosing = () -> {
            instance = null;
        };

        if(instance == null) {
            YourClass yourClass = new YourClass(onClosing);
            yourClass.initialize();
        }

        return instance;
    }

    public void yourClassMethodOne(){
        getYourClass().yourClassMethodOne();
    }

    @Override
    public void close() throws Exception {
        getYourClass().shutDown();
    }
}