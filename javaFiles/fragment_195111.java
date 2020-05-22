public ActionResult Authenticate()
        {
                var oauthFacebook = new FacebookOAuth();
                if (Request["code"] == null)
                {
                    //Redirect the user to Facebook for authorization.
                    Response.Redirect(oauthFacebook.AuthorizationLinkGet());
                }
                else
                {
                    //Get the access token and secret.
                    oauthFacebook.AccessTokenGet(Request["code"]);
                    if (oauthFacebook.Token.Length > 0)
                    {
                        //We can now make our api calls
                        var user = oauthFacebook.GetAttributes();
                    }
                }
        }