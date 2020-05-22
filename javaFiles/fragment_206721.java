String input = "{X:0.8940594 Y:0.6853521 Z:1.470214}";

Pattern pattern = Pattern.compile("-?\\d+\\.\\d+");
Matcher matcher = pattern.matcher(input);

List<String> result = new ArrayList<>();
while (matcher.find()) {
    result.add(matcher.group());
}
System.out.println(result);