public static Login POST(URL url, String user, String pw) throws IOException
{

    String data=  "api_type=json&user=" + user +"&passwd="+pw;
    HttpURLConnection ycConnection = null;
    ycConnection = (HttpURLConnection) url.openConnection();
    ycConnection.setRequestMethod("POST");
    ycConnection.setDoOutput(true);
    ycConnection.setUseCaches (false);
    ycConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
    ycConnection.setRequestProperty("Content-Length", data.length());

    PrintWriter out = new PrintWriter(ycConnection.getOutputStream());


    out.print(data.getBytes());
    out.close();

    BufferedReader in = new BufferedReader(new InputStreamReader(ycConnection.getInputStream()));
    String response = in.readLine();

    Map<String, List<String>> headers = ycConnection.getHeaderFields(); 
    List<String> values = headers.get("Set-Cookie"); 
    String cookieValue = null; 
    for (java.util.Iterator<String> iter = values.iterator(); iter.hasNext(); ) {
         String v = iter.next(); 
         if (cookieValue == null)
             cookieValue = v;
         else
             cookieValue = cookieValue + ";" + v;
    }

    return new Login(cookieValue, response);
}