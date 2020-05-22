try
{
   String memberTypeList = MemberTypeComboBox.getSelectedItem().toString();
   String sql1  ="Select MemberTypeID 
                    from jeniskeahlian 
                   where Type = ? " ;
   pst = conn.prepareStatement(sql1);
   pst.setString( 1, memberTypeList );

   rs = pst.executeQuery();
   String memberType = "";
   while(rs.next()){
      memberType = rs.getString("MemberTypeID");
   }
   rs.close();
   pst.close();

   String sql2 = "Insert into ahli (MemberID, TrainerID, Name, 
                                    ICNumber, Address, Nationality,
                                    PhoneNumber, Email, EmergencyPerson, 
                                    EmergencyContact, DateReg, MemberTypeID)
                  values(?,?,?,?,?,?,?,?,?,?,?,?)";

   pst = conn.prepareStatement(sql2);

   pst.setString(1, MemberIDTextField.getText());
   pst.setString(2, valueTrainer);
   pst.setString(3, NameTextField.getText());
   pst.setString(4, jTextField1.getText());
   pst.setString(5, AddressTextArea.getText());

   //Nationality combo box
   String nationalityList = NationalityComboBox.getSelectedItem().toString();
   pst.setString(6, nationalityList);

   pst.setString(7, PhoneNumberTextField.getText());
   pst.setString(8, EmailTextField.getText());
   pst.setString(9, EmerContactPersonTextField.getText());
   pst.setString(10, EmerContactNumberTextField.getText());

   //Date Chooser
   pst.setString(11, ((JTextField)MemberDateChooser
                                 .getDateEditor()
                                 .getUiComponent()).getText());
   pst.setString(12, memberType);

   pst.execute();

   JOptionPane.showMessageDialog(null, "New member has been added");

} // try