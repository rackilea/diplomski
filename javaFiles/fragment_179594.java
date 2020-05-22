System.setProperty("sun.net.http.allowRestrictedHeaders", "true"); // this line is important to allow change in the Host header
Connection con = Jsoup.connect("http://208.80.154.224/wiki/Cricket")
                    .userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36")
                    .timeout(1000*5)
                    .followRedirects(true)
                    .header("Host","en.wikipedia.org") // new entry here
                    .referrer("http://www.google.com");