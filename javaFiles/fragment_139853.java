Pattern pattern = Pattern.compile('\\S+ \\S+');
Matcher matcher = pattern.matcher(inputString);
int matchCount = 0;
boolean found = matcher.find();
while (found) {
  matchCount += 1;
  // search starting after the last match began
  found = matcher.find(matcher.start() + 1);
}