URL sandbox = new URL("https://api.sandbox.paypal.com/v1/oauth2/token");
URLConnection yc = sandbox.openConnection();

BufferedReader in = new BufferedReader(new InputStreamReader(
    yc.getInputStream()));
String inputLine;
while ((inputLine = in.readLine()) != null)
   System.out.println(inputLine);
in.close();