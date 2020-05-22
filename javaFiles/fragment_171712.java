OKbtn.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {

        char [] pass = passwordTxt.getPassword();
        String PASSWORD = new String(pass);

        String FIRSTNAME,USERNAME,EMAIL;
        FIRSTNAME = firstNameTxt.getText();
        USERNAME = lastNameTxt.getText();
        EMAIL = emailAddressTxt.getText();


        String url = "jdbc:mysql://localhost:3306/System";
        String user = "root";
        String password = "";

        Connection con;
        try {
            con = DriverManager.getConnection(url, user, password);
            Statement statement = con.createStatement();
            String sqlquery = "insert into signUp_tb "+
                               "(FirstName,UserName,Email,Password) values ('"+FIRSTNAME+"','"+USERNAME+"','"+EMAIL+"','"+PASSWORD+"')";

            statement.executeUpdate(sqlquery);
            System.out.println("Insertion complete");
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }
});