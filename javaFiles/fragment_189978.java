URL url = new URL("http://bagistest.tev.org.tr/Hastane.asmx/HastaneListesi");
URLConnection connection = url.openConnection();
BufferedReader in = new BufferedReader(
        new InputStreamReader(
            connection.getInputStream()));
StringBuilder response = new StringBuilder();
String inputLine;

while ((inputLine = in.readLine()) != null) 
    response.append(inputLine);

in.close();
String trimmedResponse = response.toString().substring(1, response.toString().length() - 1);
trimmedResponse = trimmedResponse.replace("\\\"", "\"");
System.out.println(trimmedResponse);
JSONArray array = new JSONArray(trimmedResponse);
System.out.println(array.length());