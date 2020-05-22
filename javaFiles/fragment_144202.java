Pattern p = Pattern.compile("\\d\\d?:\\d\\d");
Matcher m = p.matcher(textWithTime);
if (m.find()){
    System.out.println("MATCH");
} else {
    System.out.println("NO MATCH");
}