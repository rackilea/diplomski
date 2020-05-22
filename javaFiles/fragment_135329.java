Statement stmt = conn.createStatement(); 
String req = "Select * from table where name in(";
String params = "";
for (int i = 0; i < list.size(); i++) {
        if (!params.isEmpty())
          params += ",";
        params += "'"+list.get(i)+"'";
    }

req += params + ")";
ResultSet rs = stmt.executeQuery(req);