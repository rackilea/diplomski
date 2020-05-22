String cookie = connection.getHeaderField( "Set-Cookie").split(";")[0];
Pattern pattern = Pattern.compile("content=\\\"0;url=(.*?)\\\"");
Matcher m = pattern.matcher(response);
if( m.find() ) {
    String url = m.group(1);
    connection = new URL(url).openConnection();
    connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
    connection.setRequestProperty("Cookie", cookie );
    connection.connect();
    r  = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
    sb = new StringBuilder();
    while ((line = r.readLine()) != null) {
        sb.append(line);
    }
    response = sb.toString();
    pattern = Pattern.compile("<div id=\"resultStats\">About ([0-9,]+) results</div>");
    m = pattern.matcher(response);
    if( m.find() ) {
        long amount = Long.parseLong(m.group(1).replaceAll(",", ""));
        return amount;
    }

}