StringBuffer jsonBuffer = new StringBuffer();
BufferedReader reader = null;
String line = null;
try {
    reader =  new BufferedReader(new InputStreamReader(inputStream));
    while ((line = reader.readLine()) != null)
        jsonBuffer.append(line);
} catch (Exception e) {
    //Handle error
}
finally {
    reader.close();
}
String json = jsonBuffer.toString();