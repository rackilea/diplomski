public partial class Img : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

            string url = Page.Request.QueryString["url"];

            HttpWebRequest request = (HttpWebRequest)HttpWebRequest.Create(url);
            request.Timeout = 5000;
            request.ReadWriteTimeout = 20000;
            HttpWebResponse imgresponse = (HttpWebResponse)request.GetResponse();
            //StreamReader sr = new StreamReader(imgresponse.GetResponseStream());


            Response.ContentType = "image/gif";
            byte[] fileBytes = GetFileBytes(imgresponse.GetResponseStream());
            Response.BinaryWrite(fileBytes);
            Response.Flush();

        }

        protected byte[] GetFileBytes(Stream stream)
        {

            byte[] fileBytes = null;
            byte[] buffer = new byte[4096];

            try
            {

                MemoryStream memoryStream = new MemoryStream();
                int chunkSize = 0;
                do
                {
                    chunkSize = stream.Read(buffer, 0, buffer.Length);
                    memoryStream.Write(buffer, 0, chunkSize);
                } while (chunkSize != 0);
                fileBytes = memoryStream.ToArray();

            }
            catch (Exception ex)
            {
                Response.Write(ex.Message);
            }

            return fileBytes;
        }

    }