public void actionPerformed(ActionEvent arg0) {

    Thread th=new Thread() {
      public void run() {
        try {
            String query = "SELECT * FROM EmplyeeInfo WHERE Username=? and password=?";
            PreparedStatement pst = dbconnection
                    .prepareStatement(query);

            pst.setString(1, textField_1.getText());
            pst.setString(2, passwordField_1.getText());

            ResultSet rs = pst.executeQuery();

            int count = 0;
            while (rs.next()) {
                count++;
            }
            if (count == 1) {

                textField_1.setText("");
                passwordField_1.setText("");
                JOptionPane.showMessageDialog(null,
                        "Correct Username and Password");
                startRunning();

            } else {
                textField_1.setText("");
                passwordField_1.setText("");
                JOptionPane.showMessageDialog(null, "Wrong try again");
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, e);
        }
    }
  };
  th.start();
});