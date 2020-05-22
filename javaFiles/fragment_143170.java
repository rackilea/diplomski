private void saveActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            for(int i = 0 ; i < time_table.getModel().getRowCount() ; i++)
            {
                for(int j = 1 ; j < time_table.getModel().getColumnCount() ; j++)
                {
                    String sql="insert into batch (course_code,batch_number,time,"+ time_table.getColumnName(j).toLowerCase()+")values(?,?,?,?)";

                    pst=conn.prepareStatement(sql);

                    String value1=course_code.getSelectedItem().toString();
                    pst.setString(1,value1);

                    String value2=course_code.getSelectedItem().toString();
                    pst.setString(2, value2+"-"+year.getText()+"-"+group_no.getText());

                    String value3=time_chooser.getSelectedItem().toString();
                    pst.setString(3, value3);

                    String c=time_table.getModel().getValueAt(i, 0).toString();
                    Boolean val1 = (Boolean)time_table.getModel().getValueAt(i, j);
                    System.out.println(val1 + "\t");
                    if(Boolean.TRUE.equals(val1)) {
                        pst.setString(4, c );
                        pst.executeUpdate();
                        pst.close();
                        JOptionPane.showMessageDialog(null, "Successfully Inserted");
                    }
                    System.out.println();
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }