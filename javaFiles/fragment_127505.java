private Object2 frameToDisplayWhenButtonIsClicked;

public Object2(frameToDisplayWhenButtonIsClicked) {
    this.frameToDisplayWhenButtonIsClicked;
}

...

public void actionPerformed(ActionEvent e) {
    setVisible(false);
    frameToDisplayWhenButtonIsClicked.setVisible(true);
}