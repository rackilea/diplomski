public class InnerSlider extends JSlider {

    int innerMin, innerMax;

    public InnerSlider(int min, int max, int innerMin, int innerMax){
        super(min,max);
        this.innerMin = innerMin;
        this.innerMax= innerMax;
        addChangeListener((e) -> {
            if(getValue() < innerMin){
                setValue(innerMin);
                getMouseListeners()[0].mouseReleased(null);
            }else if(getValue() > innerMax){
                setValue(innerMax);
                getMouseListeners()[0].mouseReleased(null);
            }
        });
    }
}