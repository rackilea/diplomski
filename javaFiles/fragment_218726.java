public abstract class AbstractModelAction extends AbstractAction {

    public abstract TableModel getModel();

    @Override
    public void actionPerformed(ActionEvent e) {
        ModelFrame frame = new ModelFrame(getModel());
        frame.setVisible(true);
    }
}

public class CurrencyModelAction extends AbstractModelAction {

    @Override
    public TableModel getModel() {
        return //... Create the new model based on you needs
    }

}