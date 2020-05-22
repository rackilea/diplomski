Pattern regex = Pattern.compile("<DataElements>(.*?)</DataElements>", Pattern.DOTALL);
Matcher matcher = regex.matcher(subjectString);
Pattern regex2 = Pattern.compile("<([^<>]+)>([^<>]+)</\\1>");
if (matcher.find()) {
    String DataElements = matcher.group(1);
    Matcher matcher2 = regex2.matcher(DataElements);
    while (matcher2.find()) {
        list.add(new DataElement(matcher2.group(1), matcher2.group(2)));
    } 
}