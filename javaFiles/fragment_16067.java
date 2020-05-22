Connection conn = //get connection
PreparedStatement stat = conn.prepareStatement("INSERT INTO  admission (a_id,sickness,recPhysicianDetails,admittedDate,Patient_ID,Doctor_id,Doctor_id1)"
+" VALUES(?, ?, ?, ?, (SELECT ID FROM patient WHERE Patient_name = ?),(SELECT ID FROM employee WHERE Name = ?),(SELECT ID FROM employee WHERE Name = ?))");
stat.setString(1, txt1.getText());
stat.setString(2, txt7.getText());
stat.setString(3, txt8.getText());
stat.setString(4, txt6.getText());
stat.setString(5, txt3.getText());
stat.setString(6, txt9.getText());
stat.setString(7, txt10.getText());
stat.executeUpdate();