try {
                Class.forName("com.mysql.jdbc.Driver");

                try (Connection con = DriverManager.getConnection(

                                "jdbc:mysql://localhost/database_name_here",
                                "username_here", "password_here")) {

                    String if = txtId.getText();
                    String name = txtName.getText();
                    String birthday = ftfBirthday.getText();

                    PreparedStatement stmt = con.prepareStatement(

                            "INSERT INTO records "
                            + "(id, name, birthday)"
                            + "VALUES(?,?,STR_TO_DATE(?,'%Y/%m/%d'))");

                    if (id.isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                                "The ID field must be completed!");

                    } else if (name.isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                                "The Name field must be completed!");

                    } else if ("    /  /  ".equals(birthday)) {
                        JOptionPane.showMessageDialog(null,
                                "The Birthday field must be completed!");

                    } else {

                        stmt.setString(1, id);
                        stmt.setString(2, name);
                        stmt.setString(3, birthday);

                        stmt.executeUpdate();

                        JOptionPane.showMessageDialog(this, " Data was saved successfully! ");

                    }

                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "SQL command error "
                        + e.getMessage());

            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(this,
                        " Database driver not found ");

        }