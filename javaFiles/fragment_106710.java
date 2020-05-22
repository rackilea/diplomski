class abstract BasePanel extends Panel {
    public BasePanel(String id) {
        super(id);

        //...your code.
        WebMarkupContainer actionBar = ...;

        //call this abstract method to add links in actionBar.
        addActionLinks( actionBar );
    }

    public abstract void addActionLinks( WebMarkupContainer container );
}