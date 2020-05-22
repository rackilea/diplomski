function bool CheckIfServiceIsAlive(string url)
{
var isServiceUrlAlive= false;
            var req = WebRequest.Create(url);
            if (!string.IsNullOrEmpty(proxyServer))
            {
                var proxy = new WebProxy(proxyServer, 8080) { Credentials = req.Credentials };  //if you need to use a proxy
                WebRequest.DefaultWebProxy = proxy;
                req.Proxy = proxy;
            }
            else
            {
                req.Proxy =  new WebProxy();
            }
            try
            {
                var response = (HttpWebResponse)req.GetResponse();
                isServiceUrlAlive= true;
            }
            catch (WebException) { }

            return isServiceUrlAlive;