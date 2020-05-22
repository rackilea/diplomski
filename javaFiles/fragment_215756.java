public class Spinner implements IsWidget, SpinnerPresenter{
    interface View{
        Widget asWidget();
        void stepUp(int step);
        void stepDown(int step);
        void setValue(int value);
        void setPixelSize(int width,int height);
    }   
    View view;
    int value;  
    public Spinner() {
        view = new SpinnerImpl(this);
        view.setValue(0);
    }   
    public int getValue() {
        return value;
    }   
    public void setValue(int value) {
        if (value == this.value)
            return;
        this.value = value;
        view.setValue(value);
    }
    public void setPixelSize(int width, int height){
        view.setPixelSize(width,height);
    }
    @Override
    public void downButtonClicked() {
        value--;
        view.stepDown(1);
    }
    @Override
    public void upButtonClicked() {
        value++;
        view.stepUp(1);
    }
    @Override
    public Widget asWidget() {
        return view.asWidget();
    }
}