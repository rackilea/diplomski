private ResultSet results = null;

 submit.addActionListener(new ActionListener()
 {
     public void actionPerformed(ActionEvent e)
     {
         // if there isn't any ResultSet or the current one is empty/done
         if(results == null || !results.next()) 
         {

             try{
             Class.forName(DRIVER);
             // Connection to the Database
             con = DriverManager.getConnection(DATABASE_URL,"root","");

             // Gets text from textfields and assigns them to variables
             s1 = tfKeywords.getText();
             // Gets ComboBox Selected Item
             s2 = (String)cb.getSelectedItem();

             //Creates Statement Connection
             Statement st = con.createStatement();   

             // SQL Statements 
             st.executeQuery("SELECT * FROM "+s2+" WHERE Title LIKE '%"+s1+"%'");

             // Extracts data from statement to a result set
             results = st.getResultSet();
             if(results.next())
             {
               setTexts(results);
             }

             }

             // SQL Catch block to catch errors
             catch(SQLException s){
             }
             // Catch block to catch ActionListener errors
             catch (Exception e1){   
             }   
         }else 
         {
              setTexts(results);
         }
     };   
 });