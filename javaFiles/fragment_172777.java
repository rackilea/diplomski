String ip = "2.51.255.200"; 
URL url = new URL("http://freegeoip.net/csv/" + ip);
connection = (HttpURLConnection) url.openConnection();
connection.connect();

InputStream is = connection.getInputStream();

int status = connection.getResponseCode();
if (status != 200) {
    return null;
}

reader = new BufferedReader(new InputStreamReader(is));
for (String line; (line = reader.readLine()) != null;) {
    //this API call will return something like:
    "2.51.255.200","AE","United Arab Emirates","03","Dubai","Dubai","","x-coord","y-coord","",""
    // you can extract whatever you want from it
}