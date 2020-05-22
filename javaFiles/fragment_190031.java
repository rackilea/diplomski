Connection.Response res = Jsoup.connect("http://some-site.com/login.jsp")
                        .data("username", "somename")
                        .data("password", "apass")
                        .method(Method.POST)
                        .settimeout(90000)//time set for the connection 1 min
                        .execute();
                Map<String, String> cookies = res.cookies();

                Document doc = Jsoup
                    .connect("http:/some-site.com/home.jsp")
                    .cookies(cookies)
                    .get();