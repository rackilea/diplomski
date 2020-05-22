btn.addListener (SWT.Selection,  new Listener() {           
    public void handleEvent(Event e) {
            if (!newString.isEmpty()) {
                item1.setControl(list1);
                list1.setVisible(true);
            } else {
                item1.setControl(list);
                list.setVisible(true);
            }
    }
});