ArrayList<Object> providers = new ArrayList<Object>();
            providers.add(new JacksonJsonProvider());

    WebClient client = WebClient.create(""/App1/MyApp.do", providers);

            client.header("jsessionid", someSessionId);