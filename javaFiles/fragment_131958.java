String str = "MyPref_ix__CH-DE_ProductName.pdf";

String regex = "(.*)_(CH|IT|FR|GB)-(EN|IT|FR|DE)_(.*)\\.pdf";
Pattern pattern = Pattern.compile(regex);

Matcher matcher = pattern.matcher(str);
String[] res = new String[4];

if(matcher.matches()) {
    res[0] = matcher.group(1);
    res[1] = matcher.group(2);
    res[2] = matcher.group(3);
    res[3] = matcher.group(4);
}