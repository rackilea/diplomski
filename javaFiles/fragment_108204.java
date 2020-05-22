Connection.Response res = Jsoup.connect("http://website.com/login?event=doLogin")
                               .execute();

...

Document doc = Jsoup.connect("http://website.com/login?event=doLogin")
                    .cookies(res.cookies())
                    .data("email", "my@email")
                    .data("pass", "mypass")
                    .data(name[0], value[0])
                    .data(name[1], value[1])
                    .data(name[2], value[2])
                    .post();