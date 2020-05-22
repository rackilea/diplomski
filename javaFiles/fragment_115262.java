public Window() 
{
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    setLayout(new GridBagLayout());

    InfoPane stats = new InfoPane();
    layout.gridx = 0;
    layout.gridy = 0;
    layout.ipadx = 50;
    add(stats.InfoPaneBox("John", "100", "UNSP", "Ukraine", "9\" Knife", "05", "£123", "18"), layout);

    pack();

    setVisible(true);
}