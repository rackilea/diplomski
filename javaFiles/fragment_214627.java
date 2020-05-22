new Request(
        Session.getActiveSession(),
        "/me",
        null,
        HttpMethod.GET,
        new Request.Callback() {
            @Override
            public void onCompleted(Response response) {
                GraphObject graphObject = response.getGraphObject();
                if (graphObject != null) {
                    if (graphObject.getProperty("id") != null) {
                        String fbId = graphObject.getProperty("id").toString();
                        String userName = graphObject.getProperty("name").toString();
                    }
                }
            }
        }
    ).executeAsync();