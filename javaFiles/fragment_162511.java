URL oracle = new URL("http://localhost:9200/h*/_count");
BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

String inputLine;
while((inputLine = in.readLine()) != null)
    System.out.println(inputLine);
in.close();