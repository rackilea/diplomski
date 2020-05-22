Action action = new AbstractAction("someActionCommand", someIcon) {
    @Override
    public void actionPerformed(ActionEvent e) {
        // do something.
    }
};

toolbar.add(action);