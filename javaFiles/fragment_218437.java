Action toggleAction = new AbstractAction("Start") {
    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractButton button = (AbstractButton)e.getSource();
        if (button.isSelected()) {
            button.setText("Stop");
            // Start the action here
        } else {
            button.setText("Start");
            // Stop the action here
        }
    }
};

JMenuBar menuBar = new JMenuBar();
menuBar.add(new JMenu("Settings"));
menuBar.add(new JToggleButton(toggleAction));