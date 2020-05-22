BufferedReader in = new BufferedReader(
        new InputStreamReader(urlConnection.getInputStream()));
String inputLine;
StringBuilder response = new StringBuilder();

while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();