// Create key stoke and bind the key stroke to an action
component.getInputMap().put(KeyStroke.getKeyStroke("alt"), "actionName");

// Add the action to the component
component.getActionMap().put("actionName",
    new AbstractAction("actionName") {
        public void actionPerformed(ActionEvent evt) {
            //do something here
        }
    }
);