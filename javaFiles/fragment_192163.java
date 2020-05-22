String prest= "SELECT * FROM q_table, choices, answers  WHERE questions.QID=? AND choices.CID=? AND answers.AID=?";

 prest.setInt(1,1980);
 prest.setInt(2,2004);
 .
 .
 ResultSet rs = prest.executeQuery();
 while (rs.next()){
     String mov_name = rs.getString(1);
     int mov_year = rs.getInt(2);
     count++;
     System.out.println(mov_name + "\t" + "- " + mov_year);
 }
 System.out.println("Number of records: " + count);
 prest.close();
 con.close();