public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==btn1)
            {
                 mainMenu.setVisible(true);
                 createUserMenu.setVisible(false);
                 loginUserMenu.setVisible(false);

            }
            else  if(e.getSource()==btn2)
            {
                 mainMenu.setVisible(false);
                 createUserMenu.setVisible(true);
                 loginUserMenu.setVisible(false);

            }
            else  if(e.getSource()==btn3)
            {
                 mainMenu.setVisible(false);
                 createUserMenu.setVisible(false);
                 loginUserMenu.setVisible(true);

            } 


        }