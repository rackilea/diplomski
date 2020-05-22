try {
      //Class.forName("oracle.jdbc.driver.OracleDriver");
     DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
      }catch(Exception ex){
          JOptionPane.showMessageDialog(m, ex.toString(),"Incorrect value", JOptionPane.INFORMATION_MESSAGE);
          ex.printStackTrace();

      }