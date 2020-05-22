`res = Jsoup.connect("https://thewebsite.net/index/login")
    .data("login", User).data("pass", Pass)
    .userAgent("Chrome").method(Method.POST).execute();

//then I grabbed the cookie and sent the next post for the data

Document t = res.parse(); //for later use
SessionID = res.cookie("UNIQUE_NAME");

//the JSON
Connection.Response driverx =     Jsoup.connect("https://thewebsite.net/datarequest/data").cookie("UNIQUE_NAME",SessionID).userAgent("Chrome").method(Method.POST).execute();`