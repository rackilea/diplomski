String example = "sdflkjsdflskdfs0980sdflkjmlsdf'numbers', '[1231231"
    + "23,123123123,1231232,345634,3453534,123123]');asdasdasdasd";

Pattern pattern = Pattern.compile("'numbers', '\\[(.*?)\\]'\\);");
Matcher matcher = pattern.matcher(example);

while (matcher.find()) {
  String[] numbers = matcher.group(1).split(",");
  for (String s : numbers) {
    System.out.println(s);
  }