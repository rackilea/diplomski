String regex = "([A-Za-z])\\1+";
String str = "BOobbOobboObbOoObbooOoOoOoOoOObb";

Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
Matcher matcher = pattern.matcher(str);

while (matcher.find()) {
    str = matcher.replaceFirst(matcher.start() > 0 ? matcher.group(1)
                                    .toLowerCase() : matcher.group(1));
    matcher.reset(str);
}

System.out.println(str); // Bobobobobob