String regex = "\"[^\"]+\"|[^,]+";
Pattern p = Pattern.compile(regex);
Matcher m = p.matcher(thisLine);
while(m.find()) {
    System.out.println(thisLine.substring(m.start(),m.end()));
    // I suppose you could construct an array here rather than just printing it
}