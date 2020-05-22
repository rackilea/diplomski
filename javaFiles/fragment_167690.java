ResultSet Result = pst.executeQuery();
        if (Result.next()) {
            String user = Result.getString("user_name");
            try {
                PreparedStatement pst2 = conn
                        .prepareStatement("SELECT `user_admin` FROM `table_1` WHERE `user_name` = ? AND `user_admin` = 1");

                pst2.setString(1, user);
                ResultSet Result2 = pst2.executeQuery();  // added
                if (Result2.next()) { // modified
                    frmLotusLogin.dispose();
                    new AdminPanel(user).frame.setVisible(true);
                } else {
                    frmLotusLogin.dispose();
                    new MainUserPanel(user).frmLotusSecurity.setVisible(true);
                }

            } catch (Exception exc) {

              // do something here !

            }