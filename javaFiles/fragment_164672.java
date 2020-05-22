try {
        Connection.Response response = Jsoup.connect("http://www.gpro.net/gb/Login.asp?langCode=gb&Redirect=gpro.asp")
                .method(Connection.Method.POST)
                .data("textLogin", "")  // username
                .data("textPassword", "") // password
                .data("Logon", "Login")
                .execute();

        System.out.println(response.body());
        System.out.println(response.cookies());
    } catch (IOException e) {
        e.printStackTrace();
    }