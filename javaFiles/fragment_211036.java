String line = "My first thumb drive stored 1.5GB, but second stored 1TB.";
String pattern = "\\b(\\d+(?:\\.\\d+)?)(?:MB|GB|TB)\\b";

Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(line);

while (m.find()) {
    System.out.println("Found value: " + m.group(1) );
}

Found value: 1.5
Found value: 1