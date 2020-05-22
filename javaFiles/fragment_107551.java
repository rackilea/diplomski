List < String > list = new ArrayList < >();

try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {

    //br returns as stream and convert it into a List
    list = br.lines().collect(Collectors.toList());

} catch(IOException e) {
    e.printStackTrace();
}

StringBuilder sb = new StringBuilder();
for (String s: list) {
    sb.append(s);
}

String json = sb.toString()
JSONParser parser = new JSONParser();
obj = parser.parse(json);