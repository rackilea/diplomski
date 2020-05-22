bufferedReader = new BufferedReader(
                     new InputStreamReader(
                         response.getEntity().getContent()));

StringBuffer stringBuffer = new StringBuffer("");
String line = "";
String LineSeparator = System.getProperty("line.separator");

while ((line = bufferedReader.readLine()) != null) {
    stringBuffer.append(line + LineSeparator); 
}

bufferedReader.close();