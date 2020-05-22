public class FacebookOAuth : Oauth
    {
        public FacebookOAuth()
        {
            Authorize = "https://graph.facebook.com/oauth/authorize";
            AccessToken = "https://graph.facebook.com/oauth/access_token";
            CallbackUrl = "http://<YourURLHere>/Authenticate";
            AttributesBaseUrl = "https://graph.facebook.com/me/?access_token=";
            ConsumerKey = ConfigurationManager.AppSettings["FacebookConsumerKey"];//Ur Consumer Key goes here
            ConsumerSecret = ConfigurationManager.AppSettings["FacebookConsumerSecret"];//Ur Consumer secret goes here
            Provider = "Facebook";
        }

        public override string AuthorizationLinkGet()
        {
            return
                string.Format(
                    "{0}?client_id={1}&redirect_uri={2}&scope=email,user_education_history,user_location,user_hometown",
                    Authorize, ConsumerKey, CallbackUrl);
        }

        public User GetAttributes()
        {
            string attributesUrl = string.Format("{0}{1}", AttributesBaseUrl, Token);
            string attributes = WebRequest(Method.Get, attributesUrl, String.Empty);
            var FacebookUser = new JavaScriptSerializer().Deserialize<FacebookUser>(attributes);
            return new User()
            {
                FirstName = FacebookUser.first_name,
                MiddleName = FacebookUser.middle_name,
                LastName = FacebookUser.last_name,
                Locale = FacebookUser.locale,
                UserEmail = FacebookUser.email,
                AuthProvider = Provider,
                AuthToken=Token
            };
        }
    }