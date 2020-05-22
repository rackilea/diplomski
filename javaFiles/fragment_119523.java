Action myAction = new AbstractAction("Some action") {

    @Override
    public void actionPerformed(ActionEvent e) {
        // do something
    }
};

// use the action on a button
JButton myButton = new JButton(myAction);  

// use the same action for a keypress
myComponent.getInputMap().put(KeyStroke.getKeyStroke("F2"), "doSomething");
myComponent.getActionMap().put("doSomething", myAction);