String htmlString = "Some very long webpage string that includes the above tag"
Pattern pattern = Pattern.compile("softwareVersion\"> ([^ <]*)</dd");
                                               //     ^------^ Here
Matcher matcher = pattern.matcher(htmlString);
while (matcher.find()) {
    System.out.println(matcher.group(1));
}