String ris=null;

         q = "SELECT DISTINCT nome FROM malattia WHERE eta='" + age + "' AND sesso='" + sexstr + "' AND etnia='" + etniastr + "' AND sintomi IN(" + tes + ")";

                    ResultSet rs = st.executeQuery(q);
                    rs.first(); // go to first record.
                      //This is the place where I'm having problems
                        while(rs.next()){
                      //ris is supposed to get the name of the query result having column "nome"
                        ris=rs.getString("nome");

                                      }
                         }


              conn.close();