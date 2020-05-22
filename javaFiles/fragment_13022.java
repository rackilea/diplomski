/**
 * Called by the constructor methods to create the default 
 * <code>contentPane</code>. 
 * By default this method creates a new <code>JComponent</code> add sets a 
 * <code>BorderLayout</code> as its <code>LayoutManager</code>.
 * @return the default <code>contentPane</code>
 */
protected Container createContentPane() {
    JComponent c = new JPanel();
    c.setName(this.getName()+".contentPane");
    c.setLayout(new BorderLayout() {
        /* This BorderLayout subclass maps a null constraint to CENTER.
         * Although the reference BorderLayout also does this, some VMs
         * throw an IllegalArgumentException.
         */
        public void addLayoutComponent(Component comp, Object constraints) {
            if (constraints == null) {
                constraints = BorderLayout.CENTER;
            }
            super.addLayoutComponent(comp, constraints);
        }
    });
    return c;
}