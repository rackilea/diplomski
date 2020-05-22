String inputLine;
StringBuffer response = new StringBuffer();

while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
    System.out.println(inputLine);
}

JSONObject obj = new JSONObject(inputLine);