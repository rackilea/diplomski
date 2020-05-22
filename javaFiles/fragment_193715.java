public boolean Login(String user, String pass, String url) {
        try {
            final WebClient webClient = new WebClient();

            // Get the first page
            final HtmlPage page1 = webClient.getPage(url);

            // Get the form that we are dealing with and within that form,
            // find the submit button and the field that we want to change.
            final HtmlForm form = page1.getFormByName("oauthAuthorizeForm");

            final HtmlSubmitInput button = form.getInputByName("authorize");
            final HtmlTextInput textField = form.getInputByName("session_login");
            final HtmlPasswordInput textField2 = form.getInputByName("session_password");
            // Change the value of the text field
            textField.setValueAttribute(user);
            textField2.setValueAttribute(pass);

            // Now submit the form by clicking the button and get back the second page.

            final HtmlPage page2 = button.click();
            String newurl = page2.getUrl().toString();
            String oauthVerifier = newurl.split("oauth_verifier=")[1].split("&")[0];
            accessToken = oauthService.getOAuthAccessToken(requestToken, oauthVerifier);

            webClient.closeAllWindows();
            logined = true;
            return true;

        } catch (Exception ex) {
            Logger.getLogger(ClassLinkedIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }