try {

            String url = "https://www.e-cigarette-forum.com/forum/login/login/";

            Connection.Response response = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")
                    .data("login", "username")
                    .data("password", "password")
                    .method(Connection.Method.POST)
                    .followRedirects(true)
                    .execute();

            Document document = response.parse();

            System.out.println("Hi " + document.select(".username.NoOverlay").html());

            Document doc = Jsoup.connect("https://www.e-cigarette-forum.com/forum/account/personal-details")
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")
                    .cookies(response.cookies())
                    .followRedirects(true)
                    .get();

            System.out.println(doc);

        } catch (IOException e) {
            e.printStackTrace();
        }