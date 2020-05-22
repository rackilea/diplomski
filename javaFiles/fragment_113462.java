import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Controller2 {
    private Model2 model2;
    private View2 view2;

    public Controller2(Model2 model2, View2 view2) {
        this.model2 = model2;
        this.view2 = view2;
        model2.addPropertyChangeListener(Model2.TEXT, new ModelListener());
    }

    private class ModelListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent pcEvt) {
            view2.setText((String) pcEvt.getNewValue());
        }
    }
}