StringBuilder sw = new StringBuilder();
BufferedReader reader = new BufferedReader( new FileReader(file));
String readline = "";
while ((readline = reader.readLine()) != null) { 
    sw.append(readline);
}
String string = sw.toString();