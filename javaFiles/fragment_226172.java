try{
                Connection conn = DriverManager.getConnection("dbinfo");
                String query = "UPDATE Patient SET  
          PatID=?,FirstName=?,LastName=?,Address=?,City=?,Phone=?,MedID=? ` `WHERE PatID=? AND MedID=?";

                PreparedStatement pst = conn.prepareStatement(query);
                pst.setString(1, pid);
                pst.setString(2, fn );
                pst.setString(3, ln );
                pst.setString(4, add );
                pst.setString(5, city );
                pst.setString(6, phone );
                pst.setString(7, mid );
                 pst.setString(8, mid );//this last two
                pst.setString(9, pid);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Patient Updated");
                pst.close();

            }catch(Exception ex){
                ex.printStackTrace();
            }