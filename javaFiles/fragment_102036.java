BufferedReader in = new BufferedReader(new FileReader("path/of/text"));
String str;

List<String> list = new ArrayList<String>();
while((str = in.readLine()) != null){
    list.add(str);
}

String[] stringArr = list.toArray(new String[0]);