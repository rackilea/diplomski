final String url = "http://www.complaintsboard.com/?search=justanswer.com&complaints=Complaints";
final String userAgent = "Mozilla/5.0 (X11; U; Linux i586; en-US; rv:1.7.3) Gecko/20040924 Epiphany/1.4.4 (Ubuntu)";

Document doc = Jsoup.connect(url) // you get a 'Connection' object here
                        .userAgent(userAgent) // ! set the user agent
                        .timeout(10 * 1000) // set timeout
                        .get(); // execute GET request