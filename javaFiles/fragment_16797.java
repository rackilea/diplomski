public String medico(int age, String sexstr, String etniastr, String[] sintom)  {

      String tes= singleQuoteAndComma(sintom);
      String ris = "no";
      String q;
      String errore = connetti();
        try {
          if (errore.equals("")) {
            Statement st = conn.createStatement();
            //ESECUZIONE QUERY

       q = "SELECT DISTINCT nome FROM malattia WHERE eta='" + age + "' AND sesso='" + sexstr + "' AND etnia='" + etniastr + "' AND sintomi IN(" + tes + ")";

                    ResultSet rs = st.executeQuery(q);
                    if (!rs.last()) {
                          ris = "no";
                    } else {
                          ris = "si";
                    }
              } else {
                    ris = errore;
              }
              conn.close();
            } catch (Exception e) {
              ris = e.toString();
            }
            return ris;
        }