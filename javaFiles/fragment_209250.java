Redirect to: 
"https://graph.facebook.com/oauth/authorize?" +
            "client_id=" + clientId + "&" +
            "redirect_uri=" + URLEncoder.encode(returnUrl, "utf-8") 
// After redirect to the return url do the following:

//Make a http request to 
"https://graph.facebook.com/oauth/access_token?client_id=" +
            "client_id=" + clientId + "&" +
            "redirect_uri=" + URLEncoder.encode(returnUrl, "utf-8")  + "&"+
            "client_secret=" + clientSecret + "&"+
            "code=" + request.getParameter("code");