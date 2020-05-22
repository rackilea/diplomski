JMenuItem newItem = new JMenuItem("New Customer");  
 newItem.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               MainMenu.this.dispose();
               New_Customer nn = new New_Customer() {};
           }
       });