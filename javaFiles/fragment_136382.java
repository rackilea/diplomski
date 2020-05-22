loginButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            String userid = userField.getText();
            String password = passField.getText();

                if(userid.isEmpty()) 
                {
                System.out.println("Your userid and/or password cannot be nothing.");
                } 
                else 
                {
                System.out.println(userid);                 

                if(password.isEmpty()) 
                {
                System.out.println("Your password cannot be nothing.");
                } 
                else 
                {
                System.out.println(password);
                }

                // -----------
                YourFTPClient c = new YourFTPClient(user, pass);
                c.anyMethod();
            }
        }
    });