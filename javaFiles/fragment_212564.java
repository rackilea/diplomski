public class Test extends JPanel{

    private static final long serialVersionUID = 1L;

    List<Object> objects = new ArrayList<Object>();

    JTable billTable = new JTable();
    JTableBinding<UiBillItem, UiBill, JTable> jTableBinding;

    private void init(){
        objects = getNames();
    }

    private List<Object> getNames() {
        // for better to bind, it should return list of details object
        List<Object> list = new ArrayList<Object>();
        return list;
    }

    private void initDataBindings(){

        // for table binding
        BeanProperty<Test, List<Object>> uiBillBeanProperty = BeanProperty.create("objects");
        jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE, this, uiBillBeanProperty, billTable);

        BeanProperty<Test, Float> uiBillItemBeanProperty_3 = BeanProperty.create("quantity"); // property need to show 
        jTableBinding.addColumnBinding(uiBillItemBeanProperty_3).setColumnName("Qty");
        // can create multiple property like this 

    }
}