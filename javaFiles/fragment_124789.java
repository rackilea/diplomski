//creating reader to get data from file
BufferedReader in = new BufferedReader(new InputStreamReader(
        new FileInputStream("data.txt")));// file with your data

StringBuilder sb = new StringBuilder();
String line = null;
while ((line = in.readLine()) != null) {
    sb.append(line.trim());// also remove unnecessary tabulators and
                            // spaces
}
in.close();

String data = sb.toString();

Pattern pattern = Pattern.compile("\\{memory,\\[(.*?)\\]");
Matcher m = pattern.matcher(data);
if (m.find()) {
    Pattern keyValuePattern = Pattern.compile("\\{(\\w*?),(\\d*?)\\}");
    Matcher matcher = keyValuePattern.matcher(m.group(1));
    while (matcher.find())
        System.out.println(matcher.group(1) + "->" + matcher.group(2));
} else
    System.out.println("not found");