public static class Users {
    public String name;
    public String password;

    Users(String name1, String password1) {
        name = name1;
        password = password1;
    }
    public String getName()
    { return this.name;
       }
    public String getPassword()
    {return this.password;
     }
}

Users user1, user2;
public static void FileRead() {
    try {
        BufferedReader in = new BufferedReader(new FileReader("C:/Users/B_Ali/Documents/NetBeansProjects/JavaApplication20/UserNamePassword.txt"));
        String[] s1 = new String[5];
        String[] s2 = new String[5];
        int i = 0;
        while ((s1[i] = in.readLine()) != null) {
            s1[i] = s2[i];
            i = i + 1;

            if (i == 1) {
                Users user1 = new Users(s2[0], s2[1]);
            }
            else if (i == 3) {
                Users user2 = new Users(s2[2], s2[3]);
            }
            else if (i == 5) {
                Users user3 = new Users(s2[4], s2[5]);
            }
        }
        in.close();
    }
    catch (FileNotFoundException ex) {
        Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
    }
    catch (IOException ex) {
        Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
    }

}

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    JOptionPane.showMessageDialog(null, user1.getName());
    // TODO add your handling code here:
}