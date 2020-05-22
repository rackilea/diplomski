public abstract class Oauth
    {
        #region Method enum

        public enum Method
        {
            Get,
            Post,
            Delete
        } ;

        #endregion

        protected string AccessToken;
        protected string AttributesBaseUrl;
        protected string Authorize;
        protected string CallbackUrl;
        protected string ConsumerKey;
        protected string ConsumerSecret;
        public string Provider { get; protected set; }

        public string Token { get; set; }

        public virtual string AuthorizationLinkGet()
        {
            return
                string.Format(
                    "{0}?client_id={1}&redirect_uri={2}&scope=publish_stream,email,user_education_history,user_location",
                    Authorize, ConsumerKey, CallbackUrl);
        }

        public void AccessTokenGet(string authToken)
        {
            Token = authToken;
            string accessTokenUrl = string.Format("{0}?client_id={1}&redirect_uri={2}&client_secret={3}&code={4}",
                                                  AccessToken, ConsumerKey, CallbackUrl, ConsumerSecret, authToken);
            string response = WebRequest(Method.Get, accessTokenUrl, String.Empty);

            if (response.Length > 0)
            {
                //Store the returned access_token
                NameValueCollection qs = HttpUtility.ParseQueryString(response);

                if (qs["access_token"] != null)
                {
                    Token = qs["access_token"];
                }
            }
        }

        public string WebRequest(Method method, string url, string postData)
        {
            StreamWriter requestWriter;
            string responseData = string.Empty;

            var webRequest = System.Net.WebRequest.Create(url) as HttpWebRequest;
            if (webRequest != null)
            {
                webRequest.Method = method.ToString();
                webRequest.ServicePoint.Expect100Continue = false;
                webRequest.Timeout = 20000;

                if (method == Method.Post)
                {
                    webRequest.ContentType = "application/x-www-form-urlencoded";
                    //POST the data.
                    requestWriter = new StreamWriter(webRequest.GetRequestStream());
                    try
                    {
                        requestWriter.Write(postData);
                    }

                    finally
                    {
                        requestWriter.Close();
                    }
                }
                responseData = WebResponseGet(webRequest);
            }
            return responseData;
        }

        public string WebResponseGet(HttpWebRequest webRequest)
        {
            StreamReader responseReader = null;
            string responseData;
            try
            {
                responseReader = new StreamReader(webRequest.GetResponse().GetResponseStream());
                responseData = responseReader.ReadToEnd();
            }
            finally
            {
                if (webRequest != null) webRequest.GetResponse().GetResponseStream().Close();
                if (responseReader != null) responseReader.Close();
            }
            return responseData;
        }
    }