DefaultTableModel model = null;
           // jTable1.setModel(model);

             while (rs.next()) {

                  model = (DefaultTableModel) jTable1.getModel();

                  String id,fname,sex,course,contact,email;
                  id = rs.getString("ID");
                  fname = rs.getString("full_name");
                  sex = rs.getString("sex");
                  course = rs.getString("course");
                  contact = rs.getString("contact");
                  email = rs.getString("email");

                   model.addRow(new Object[] {id,fname,sex,course,contact,email});
                   model.fireTableDataChanged();
                   JOptionPane.showMessageDialog(null, rs.getString("sex"));
              }