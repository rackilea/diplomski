InputStream stream = null;
XMLparser xmlParser = new XMLparser();
List<Customer> customers = null;

String parseUrl = URL + getCustID.getText().toString();

try
{
    stream = downloadUrl(parseUrl);
    customers = xmlParser.parse(stream);
}
finally
{
    stream.close();
}