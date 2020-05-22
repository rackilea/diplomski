btn.addListener (SWT.Selection,  new Listener() {           
    public void handleEvent(Event e) {
            if (newString != null && !newString.isEmpty()) {
                if (item1.getControl() != list1) {
                    item1.setControl(list1);
                }
            } else {
                if (item1.getControl() != list) {
                    item1.setControl(list);
                }
            }
    }
});