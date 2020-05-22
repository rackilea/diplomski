try {
String fullString = "";
    URL url = new URL(inputURL);
    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
    String line;
    while ((line = reader.readLine()) != null) {
        fullString += line;
    }
    reader.close();

    return fullString;
} catch(Exception ex) {
ex.printStackTrace();
}
return null;