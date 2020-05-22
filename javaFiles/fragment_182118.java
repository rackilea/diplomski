JSONArray objarr = new JSONArray();
 //read  from DB
sql = "SELECT id, name FROM test";
ResultSet rs = stmt.executeQuery(sql);
while (rs.next()) {

        JSONObject obj = new JSONObject(); // updated

        // Retrieve by column name
        int id = rs.getInt("id");
        String first = rs.getString("name");

        // Display values
        System.out.print("\nID: " + id);
        System.out.print(", Name: " + first);

        obj.put("name", first);
        obj.put("id", id);
        objarr.add(obj);
        System.out.print("\nobj: "+obj);
    }
    response.setContentType("application/json");
response.setCharacterEncoding("UTF-8");

PrintWriter out = response.getWriter();
out.print(objarr);
out.flush();