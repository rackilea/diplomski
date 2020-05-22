String service_name;
   String price_value = null;
    try{
       service_name=(String)jComboBox1.getSelectedItem(); //GET SELECTED SERVICE
       String query= "Select * from services where service_name='"+service_name+"'";

        stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery(query);

         while(rs.next())
         {
             if(rs.getString("service_name").equalsIgnoreCase(service_name)) //GET PRICE OF SERVICE
               price_value=rs.getString("Price");


         }
         //get employee name
         String emp_name=(String)jComboBox2.getSelectedItem();
           if (emp_name.equals("No one")) {
               emp_name="";
           }

           // insert the new row

      int row_count = jTable1.getRowCount();
       Object[] row_data={service_name,price_value,emp_name};
       dtm.insertRow(row_count, row_data);



    }
    catch(SQLException  e){

        javax.swing.JOptionPane.showMessageDialog(this,
                "ERROR IN ADDING SERVICE TO BILL\n"+e.toString(),"ERROR MESSAGE",
                javax.swing.JOptionPane.WARNING_MESSAGE);

    }