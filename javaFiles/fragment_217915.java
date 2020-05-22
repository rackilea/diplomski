@Override
    protected String doInBackground(String... urls) {

      String response = "";
      try {

            Class.forName("com.mysql.jdbc.Driver");  
            System.out.println("driver conectado");
            Connection con = DriverManager.getConnection("jdbc:mysql://10.0.2.2:3306/savetime", "root", "root");
            resultado = "Database connection success\n";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from ingresso");
            //ResultSetMetaData rsmd = rs.getMetaData();

            while(rs.next()) {

                resultado = rs.getString(1);
            }

            AUX = resultado ;
            response = AUX;  // Add here
            System.out.println("Auxiliar 1: " + AUX + " e " + resultado);
      }
      catch(Exception e) {
          e.printStackTrace();
          System.out.println("ERRO: " + e.toString());
      }
    return response;
}