String input = "INSERT INTO tableA ... INSERT INTO tableB";
String pattern = "insert into ([\\s]+)";
List<String> tables = new ArrayList<>();

Pattern r = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);

Matcher m = r.matcher(input);
while (m.find()) {
    tables.add(m.group(1));
    System.out.println(m.group(1));
}

tableA
tableB