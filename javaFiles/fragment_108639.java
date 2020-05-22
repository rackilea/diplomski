BufferedReader in = new BufferedRead(new InputStreamReader(connection.getInputStream()));

String inputLine;
while ((inputLine = in.readLine()) != null){
    System.out.println(inputLine);
}
in.close();