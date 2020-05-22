private JToggleButton lastButton;

public void actionPerformed(ActionEvent e){
    if (lastButton == null) {
        lastButton = (JToggleButton)e.getSource();
        return;
    }

    JToggleButton btn = (JToggleButton)e.getSource();

    firstClick(btn, lastButton);
    secondClick(btn, lastButton);
    matching(btn, lastButton);

    lastButton = null;
}