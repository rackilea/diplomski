Response res = Jsoup
    .connect("http://services2.hdb.gov.sg/webapp/BB33RTIS/BB33SSearchWidget")
    .timeout(10000) // edit: set timeout to 10 seconds
    .method(GET)
    .execute();

Map<String,String> cookies = res.cookies();