String REGEX = "(^[a-zA-Z](?=.*\\d{3,})(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%])(?=\\s+).{10,})";
String INPUT = "your password";
Pattern pattern = Pattern.compile(REGEX);
Matcher matcher = pattern.matcher(INPUT);
System.out.println("matches(): "+matcher.matches());


^[a-zA-Z]           # Start with a letter
(?=.*\\d{3,})       # at least three digits must occur
(?=.*[a-z])         # a lower case letter must occur at least once
(?=.*[A-Z])         # an upper case letter must occur at least once
(?=.*[@#$%])        # a special character must occur at least once
(?=\\s+)            # a space must occur at least once
.{10,}              # anything, at least ten places though
$                   # end-of-string