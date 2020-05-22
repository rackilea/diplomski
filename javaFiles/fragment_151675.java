String fn = URLEncoder.encode(fristname, "utf-8");
String sn = URLEncoder.encode(secondname, "utf-8");

LoadingDataURL client = new LoadingDataURL();
client.execute("https://domain.com/index.php?"+
                "fristname=" + fn + "&secondname=" + sn);