tabbedPane.addTab("lastpanel", jPanel5);

// add statechange event after adding 3 panels
tabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
        public void stateChanged(javax.swing.event.ChangeEvent evt) {
            tabbedPaneStateChanged(evt);
        }
});