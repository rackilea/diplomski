private void searchquantity(){

         Connection connection =getConnection();

         String query ="SELECT * FROM Products WHERE Pro_Quantity <=20";
         Statement sts=null;
         ResultSet rsr=null;
         int a=0;
         try{
            sts = connection.createStatement();
            rsr = sts.executeQuery(query);

             while(rsr.next()) {
              JOptionPane.showMessageDialog(null,rsr.getString("Pro_Id"));
              JOptionPane.showMessageDialog(null,rsr.getString("Pro_Name"));
              a=1;
             }
              if (a==0){

            JOptionPane.showMessageDialog(null, "Not Found");
            a=0;}



    }catch (Exception e) { JOptionPane.showMessageDialog(null, e); }
}