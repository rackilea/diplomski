final String regex = "\\S+\\s*|\\s+";
final String string = "a b  c   d";

final Pattern pattern = Pattern.compile(regex);
final Matcher matcher = pattern.matcher(string);

List<String> result = new ArrayList<>();

while (matcher.find()) {
    result.add( matcher.group(0) );
}

System.out.println(result);