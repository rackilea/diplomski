private void findSomething()
{
    for (int i = 0; i < 5; i++) {
        System.out.println("Request to " + urls[i]);
        WebView webView = ctrl.createWebView();
        webView.setUserData(urls[i]);
        webView.getEngine().getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>()
        {
            @Override
            public void changed(ObservableValue ov, Worker.State oldState, Worker.State newState)
            {
                if (newState == Worker.State.SUCCEEDED) {
                    // The BIG QUESTION is: What is the corresponding WebEngine to call?
                    Document doc = webView.getEngine().getDocument();

                    String userData = webView.getUserData().toString();
                    switch (userData) {
                        case "https://google.com":
                            System.out.println(doc.getElementsByTagName("title").item(0).getTextContent());
                            System.out.println("Do something with the google site");
                            System.out.println("");
                            break;
                        case "https://youtube.com":
                            System.out.println(doc.getElementsByTagName("title").item(0).getTextContent());
                            System.out.println("Do something with the youtube site");
                            break;
                        case "https://facebook.com":
                            System.out.println(doc.getElementsByTagName("title").item(0).getTextContent());
                            System.out.println("Do something with the facebook site");
                            break;
                        case "https://twitter.com":
                            System.out.println(doc.getElementsByTagName("title").item(0).getTextContent());
                            System.out.println("Do something with the twitter site");
                            break;
                        case "https://stackoverflow.com":
                            System.out.println(doc.getElementsByTagName("title").item(0).getTextContent());
                            System.out.println("Do something with the stackoverflow site");
                            break;
                    }

                    // As you will see, the responses print in totally random order
                }
            }
        });

        webView.getEngine().load(urls[i]);
    }
}