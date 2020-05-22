try
        {   
            String str=tf1.getText();
            if ( !(str.matches("[a-zA-Z]+"))) {
                  JOptionPane.showMessageDialog(null,"Please insert only characters.");
                  tf1.setText("");
            }else{

            Connection con;
            PreparedStatement ps;
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("jdbc:odbc:test");
            ps=con.prepareStatement("insert into test values('"+str+"')");
            ps.executeUpdate();
            con.close();
            ps.close();
            JOptionPane.showMessageDialog(null,"DATA SUBMITTED SUCCESSFULLY.");}
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Exception Occurred.");
        }