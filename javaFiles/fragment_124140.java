/**Local*/
boolean isStudent = false;
    try {
         String idnr = GebruikersnaamTekst.getText().trim();
         if (idnr.matches("Cursist")) {
        BasisScherm b = new BasisScherm();
            b.setVisible(true);
            setVisible(false);   
            isStudent=true;
        }
    } catch (Exception e) {
    }
if(!isStudent)
{
/**Internet*/
  try

   {

    String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
    Class.forName(driver);

    String db = "jdbc:odbc:db1";
    con = DriverManager.getConnection(db);
    st = con.createStatement();

    }
    catch(Exception e)
    {

  }

   try
        {

        String idnr = GebruikersnaamTekst.getText().trim();
        String pass = Password.getText().trim();

        String sql = "select idnr,pass from Table1 where idnr='"+idnr+"'and pass='"+pass+"'";
        rs = st.executeQuery(sql);

           int count = 0;
        while(rs.next())
        {
            count = count + 1;
        }

          if (count == 1) {
        BasisScherm b = new BasisScherm();
            b.setVisible(true);
            setVisible(false);   
        }

        else 
        {
            JOptionPane.showMessageDialog(null, "Gebruiker niet gevonden!");
        }

        }
        catch(Exception ex )
        { 
        }

}  }//end if