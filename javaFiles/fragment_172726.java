jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
          //this will be called on tab i.e when the field looses focus
              jTextField1FocusLost(evt);
        }
    });

private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {                                    
    jTextField1.setText("Box1");
}