public abstract class AbstractController { 
    private View view;

    public AbstractController(View view) {
        this.view = view;
    }

    public view getView() {
        return view;
    }

    public void someMethod() {
        // can now call view methods here
    }

}