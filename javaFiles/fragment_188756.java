int j=0;
while (rs.next()) {      
   airport[j] = rs.getString("airportname");// get value in airportname column
                                            // and add to array
   j++;
}