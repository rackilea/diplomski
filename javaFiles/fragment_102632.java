URL oracle = new URL("http://www.oracle.com/");
BufferedReader in = new BufferedReader(
    new InputStreamReader(
    oracle.openStream()));

String inputLine;

while ((inputLine = in.readLine()) != null)
  System.out.println(inputLine);

in.close();