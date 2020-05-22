// JSON Object
    JSONObject testJson = new JSONObject();

    testJson.put("connectionname", "drinkss");
    testJson.put("jdbcurl", "jdbc:mysql://localhost/drink");
    testJson.put("schema", "datasources/dr.xml");
    testJson.put("driver", "com.mysql.jdbc.Driver");
    testJson.put("username", "root");
    testJson.put("password", "211218");
    testJson.put("connectiontype", "MONDRIAN");

    // For Posting datasource into server
    Response document1 = Jsoup
            .connect(
                    "http://localhost:8080/saiku/rest/saiku/admin/datasources/")
            .header("Content-Type", "application/json")
            .requestBody(testJson.toString())
            .data(testJson)
            .ignoreContentType(true)
            .referrer("http://localhost:8080/")
            .cookie("JSESSIONID", res.cookie("JSESSIONID"))
            .userAgent(
                    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36")
            .method(Method.POST).timeout(10000).execute();
    System.out.println("post successfully....."
            + testJson.toJSONString());