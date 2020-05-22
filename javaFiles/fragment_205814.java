URL iurl = new URL(url);
HttpURLConnection uc = (HttpURLConnection)iurl.openConnection();
uc.connect();
if (uc.getContentType().equalsIgnoreCase("image/jpeg"))
{
  result = true;
}