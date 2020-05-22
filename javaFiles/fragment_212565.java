public class Test extends JPanel{

    private JLabel lblName;
    Details details;

    public Test(){
        lblName = new JLabel();
        add(lblName);

        init();
        initBinding();
    }
    private void init() {

        String sql = "SELECT * FROM details limit 1";
        try
        {
        con = Db.getConnection();
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();

        details = (Details) rs;
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    private void initBinding(){
        BeanProperty<Details, Srting> beanProperty = BeanProperty.create("name");
        BeanProperty<JLabel, String> jTextFieldBeanProperty = BeanProperty.create("text");
        AutoBinding<Details, String, JLabel, String> autoBinding_20 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, details, beanProperty, lblName, jTextFieldBeanProperty);
        autoBinding_20.bind();

        // can bind variables 
    }

}

class Details(){

    private Stirng name;

    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
            this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(String propertyName,
            PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(String propertyName,
            PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(propertyName,
                listener);

    }

    protected void firePropertyChange(String propertyName, Object oldValue,
            Object newValue) {
        propertyChangeSupport.firePropertyChange(propertyName, oldValue,
                newValue);

    }
}