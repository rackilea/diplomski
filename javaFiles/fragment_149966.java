Vector <Double> em = new Vector();
ResultSet rs5 = (ResultSet) st1.executeQuery("SELECT Amount FROM  Incoming_Transactions WHERE  AccountNumber LIKE '" + accountnum+  "%'");
    while (rs5.next()) {       
         em.add(rs5.getDouble("Amount"));
    }
Double [] myArray = new Double[em.size()]; 
myArray = em.ToArray(myArray);
//Now do stuff with all the entries