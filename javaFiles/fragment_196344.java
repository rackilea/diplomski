public void GUI() {
    DogUI = new JFrame("Dog UI");
    DogUI.setSize(800, 600);
    DogUI.setResizable(false);
    DogUI.setLayout(new GridLayout(1,2));//1row 2col

    leftPanel = new JPanel();
    leftPanel.setBackground(Color.green);

    topPanel = new JPanel();
    topPanel.setBackground(Color.white);

    bottomPanel = new JPanel();
    bottomPanel.setBackground(Color.red);

    rightPanels = new JPanel();
    rightPanels.setLayout(new GridLayout(2,1));//2row 1col

    lb = new JLabel("Name: ");
    leftPanel.add(lb);

    lb1 = new JLabel("Image");
    topPanel.add(lb1);

    lb2 = new JLabel("Buttons");
    bottomPanel.add(lb2);

    rightPanels.add(topPanel);
    rightPanels.add(bottomPanel);

    DogUI.add(leftPanel);
    DogUI.add(rightPanels);

    DogUI.setVisible(true);
}