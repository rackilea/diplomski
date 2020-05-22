public abstract class BasePresenter<T> {

    //Activity or Fragment attached to Presenter
    protected T view;

    public void onViewCreated(T view) {
        this.view = view;
    }

    public void onStart() {

    }

    public void onResume() {

    }

    public void onPause() {

    }

    public void onStop(){

    }

    public void onDestroyed() {
//        view = null;
    }

}