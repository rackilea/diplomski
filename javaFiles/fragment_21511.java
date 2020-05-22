try {

                String url = "https://www.linkedin.com/uas/login?goback=&trk=hb_signin";
                Connection.Response response = Jsoup
                        .connect(url)
                        .method(Connection.Method.GET)
                        .execute();

                Document responseDocument = response.parse();
                Element loginCsrfParam = responseDocument
                        .select("input[name=loginCsrfParam]")
                        .first();

                response = Jsoup.connect("https://www.linkedin.com/uas/login-submit")
                        .cookies(response.cookies())
                        .data("loginCsrfParam", loginCsrfParam.attr("value"))
                        .data("session_key", "your_login")
                        .data("session_password", "your_password")
                        .method(Connection.Method.POST)
                        .followRedirects(true)
                        .execute();

                Document document = response.parse();

    //            System.out.println(document)

                System.out.println("Welcome " 
                        + document.select(".act-set-name-split-link").html());

            } catch (IOException e) {
                e.printStackTrace();
            }