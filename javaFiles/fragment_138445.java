private void addToGamePanel(){

        String[] gameNames =  con.getGameNames();
        for (int i = 0; i < gameNames.length; i++) {
            JMenuItem item = new JMenuItem(gameNames[i])
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JMenuItem menuItem = (JMenuItem) e.getSource();
                    // do something with your menu item
                    String text = menuItem.getText();
                }
            });
            jMenu2.add(item);
         }
    }