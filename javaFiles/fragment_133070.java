class CenterPanel{
    JPanel center = new JPanel();

    JButton enterButton;
    JButton exitButton;

    public void renderPanel(){
        enterButton = new JButton("enter");
        exitButton = new JButton("exit");
        center.add(exitButton);
        center.add(enterButton);
    }

    public JButton getEnterButton()
    {
       return enterButton;
    }

    public JButton getExitButton()
    {
       return exitButton;
    }

    public JComponent getGUI(){
        return center;
    }
}