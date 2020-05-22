HttpsURLConnection netCipherconnection = NetCipher.getHttpsURLConnection(url);
netCipherconnection.connect();

BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(netCipherconnection.getInputStream()));
StringBuilder stringBuilder = new StringBuilder();
String stringHTML;
while ((stringHTML = bufferedReader.readLine()) != null)
    stringBuilder.append(stringHTML);
bufferedReader.close();
Document resultDocument = Jsoup.parse(String.valueOf(stringBuilder));