JToggleButton toggleButton = new JToggleButton("Click Me");
ItemListener itemListener = new ItemListener() {
    public void itemStateChanged(ItemEvent itemEvent) {
        int state = itemEvent.getStateChange();
        if (state == ItemEvent.SELECTED) {
            System.out.println("Selected"); // show your message here
        } else {
            System.out.println("Deselected"); // remove your message
        }
    }
};
toggleButton.addItemListener(itemListener);