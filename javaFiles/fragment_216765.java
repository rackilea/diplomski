Connection.Response res = Jsoup.connect("URL")
            .data("FIELD1", "abc", "FIELD2", "abc")
            .method(Connection.Method.POST)
            .execute();

    String result = res.body();