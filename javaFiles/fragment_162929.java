final String name = (new File(filePath).getName());
final Matcher matcher = FileNamePattern.match(name);

if (matcher.matches()) {

    final String first = matcher.group(1);
    final String last = matcher.group(2);
    return first + last;

} else {

    return name;
}