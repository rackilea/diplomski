private static final String[] imageNames = {"cross.gif",
                                            "nought.gif",
                                            "cross.gif",
                                            "nought.gif",
                                            "cross.gif",
                                            "nought.gif"};
private JButton[] jbtChocs = new JButton[imageNames.length];
private ImageIcon[] foodImages = new ImageIcon[imageNames.length];

public Menu() {
    /* ... */
    for(int i = 0; i < imageNames.length; i++){
        jbtChocs[i] = new JButton(imageNames[i]);
        foodImages[i] = new ImageIcon(imageNames[i]);
        jbtChocs[i].setIcon(foodImages[i]);
        girdSetup.add(jbtChocs[i]);
        jbtChocs[i].setVerticalTextPosition(AbstractButton.BOTTOM);
        jbtChocs[i].setHorizontalTextPosition(AbstractButton.CENTER);
    }
}