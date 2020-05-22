String s = "randomstuff371 12 Mar 16 14 Jan 15 13 Feb 16 138more random381 stuff73f";
Pattern pattern = Pattern.compile("\\b\\d{2}\\s\\w+\\s\\d{2}\\b");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    System.out.println(matcher.group(0)); 
}