private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {                                         

    try {
        File user = new File("src\\Battlefield4\\Batfield\\Users\\Username.txt"); //To create a universal file for Input & Output
        File pass = new File("src\\Battlefield4\\Batfield\\Users\\Password.txt"); //To create a universal file for Input & Output
        user.getParentFile().mkdirs(); //To denote the parent file
        pass.getParentFile().mkdirs(); //To denote the parent file
        Scanner scUser = new Scanner(user).useDelimiter("#"); //To scan the Username file
        Scanner scPass = new Scanner(pass).useDelimiter("#"); //To scan the password file
        username = txtUsername.getText(); //This gets the user input
        password = txtPassword.getText(); //This gets the user input
        int pos = 0; //Indicates the position of the Username in the save file
        boolean loggedIn = false; //Flag to check if it's logged in

        while(scUser.hasNext() && scPass.hasNext()) //Runs files in congruency
        {
            if(scUser.next().equalsIgnoreCase(username) && scPass.next().equals(password))
            {
                loggedIn = true;
                scUser.close();
                scPass.close();
                new Selection(username).setVisible(true);
                this.dispose();
                break;
            }
        }
        scUser.close();
        scPass.close();
        if(loggedIn == false)
        {
            JOptionPane.showMessageDialog(null,"Incorrect Username or Password!");
        }

    }
    catch (FileNotFoundException ex)
    {
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
    }

}