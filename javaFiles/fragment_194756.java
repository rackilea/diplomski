// the action to create the component
public static class CreateAction extends AbstractAction {

    private Container parent;
    private Action enableAction;

    public CreateAction(Container parent) {
        this.parent = parent;
        enableAction = new EnableAction(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setEnabled(false);
        Component field = createTextField();
        parent.add(field);
        parent.revalidate();
        field.requestFocus();
    }

    int count;
    private Component createTextField() {
        // just for fun counting the fields we create
        JTextField field = new JTextField("field: " + count++, 20);
        field.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), 
                "createComponent");
        field.getActionMap().put("createComponent", this);
        field.getInputMap().put(KeyStroke.getKeyStroke("released ENTER"), 
                "enableCreation");
        field.getActionMap().put("enableCreation", enableAction);
        return field;
    }

}

// the action that enables another
public static class EnableAction extends AbstractAction {

    Action toEnable;

    public EnableAction(Action toEnable) {
        this.toEnable = toEnable;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        toEnable.setEnabled(true);
    }

}

// usage
final JComponent parent = new JPanel(new MigLayout("wrap"));
// here I'm lazy and let the action create the very first component as well
add.actionPerformed(null);
add.setEnabled(true);