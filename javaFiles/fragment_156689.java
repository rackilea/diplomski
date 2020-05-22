public void actionPerformed(ActionEvent e){
            String username = formattedTextField.getText();

                if(username.length() < 5){
                    System.out.println("no");
                }
                if(username.length() > 5){
                    System.out.println("continue");
                }
                //Execute when the button is pressed
                System.out.println("The button has been pressed");
            }