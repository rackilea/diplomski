c.addItemListener(new ItemListener() {

    public void itemStateChanged(ItemEvent e) {
        System.err.println(e.getStateChange());
    }
});