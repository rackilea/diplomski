string url = "http://site/generatePdfBehindFormsAuth";

// get an instance of a cookie manager since it has access to our auth cookie
CookieManager cookieManager = CookieManager.getInstance();

// get the cookie string for the site.  This looks something like ".ASPXAUTH=data"
String auth = cookieManager.getCookie(url).toString();

URLConnection conn = (URLConnection)new URL(url).openConnection();

// Set the cookie string to be sent for download.  In our case we're just copying the
//   entire cookie string from the previous connection, so all values stored in 
//   cookies are persisted to this new connection.  This includes the aspx auth 
//   cookie, otherwise it would not be authenticated
//   when downloading the file.  
conn.setRequestProperty("Cookie", auth);
conn.setDoOutput(true);
conn.connect();

// get the filename from the servers response, its typical value is something like:
//   attachment; filename="GeneratedPDFFilename.pdf"
String filename = conn.getHeaderField("Content-Disposition").split("\"")[1];

// by default, we'll store the pdf in the external storage directory
String fileRoot = "/sdcard/";

// Complete the download
FileOutputStream f = new FileOutputStream(new File(fileRoot, filename));
InputStream in = conn.getInputStream();
byte[] buffer = new byte[1024];
int len1 = 0;
while ( (len1 = in.read(buffer)) > 0 ) 
{
    f.write(buffer,0, len1);
}
f.close();
in.close();