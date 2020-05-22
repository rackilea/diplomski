public class MyComboBox extends JComboBox 
{
    @Override
    public void setModel(ComboBoxModel aModel) {
        super.setModel(aModel);
        fireActionEvent();
    }
}