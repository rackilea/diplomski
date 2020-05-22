String key = "(int|float|if|else|double)"; // is a regex to check if one of the words exist
Pattern pattern = Pattern.compile(key);
Matcher matcher = pattern.matcher(r);
while (matcher.find()) { // Checks if the matcher matches r.
  System.out.println(matcher.group()); // return all the words which matched
}