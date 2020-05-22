String input = "123456789";
  List<String> output = new ArrayList<>();

  Pattern pattern = Pattern.compile("^(.{2})(.{2})(.{3})(.{2}).*");
  Matcher matcher = pattern.matcher(input);

  if (matcher.matches()) {
     for (int i = 1; i <= matcher.groupCount(); i++) {
         output.add(matcher.group(i));
     }
  }

  System.out.println(output);