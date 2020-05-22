// You could also say "scanner.useDelimiter(Pattern.compile(":"))", but
// that's the exact same thing as saying "scanner.useDelimiter(":")".
scanner.useDelimiter(":");

// Examines each token one at a time
while (scanner.hasNext())
{
    String token = scanner.next();
    // Do something with token here...
}