String msg = "*1*20*11*30*IGNORE*53*40##";
String regex = "\\*1\\*(.*?)\\*11\\*(.*?)\\*(.*?)\\*53\\*(.*?)##";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(msg);
if (matcher.find()) {
    for (int i = 0; i < matcher.groupCount(); i++) {
        if (!matcher.group(i+1).equals("IGNORE")) {
            System.out.println(matcher.group(i+1));
        }
    }
}