xrhsths.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent t){
                    //gets there when clicked

                    if (xrhsths.isSelected()) {
                        //never gets there
                        //once you click, the menu is instantly closed, so it's not selected anymore
                        //remove this "if" statement

                        Users userObject = new Users();
                        userObject.initComponents();
                    }
                }
            });