BufferedReader br = new BufferedReader(new InputStreamReader(is));
String line;
while((line = br.readLine()) != null) {
    String[] strings = line.split(" ");
    for (String str : strings) {
         Integer foo = Integer.parseInt(str);
         //do what you need with the Integer
    }
}