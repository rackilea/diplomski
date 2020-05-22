class YourClass implements ActionListener {

    [...]

    private void addToGamePanel(){

        String[] gameNames =  con.getGameNames();
        for (int i = 0; i < gameNames.length; i++) {

            JMenuItem item = new JMenuItem(gameNames[i])
            item.addActionListener(this);
            jMenu2.add(item);
         }        
    }

    public void actionPerformed(ActionEvent e) {
        JMenuItem menuItem = (JMenuItem)(e.getSource());

        // do something with your menu item
        String text = menuItem.getText();

    }
}