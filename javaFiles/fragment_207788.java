String s = "mutuallyexclusive";
Pattern pattern = Pattern.compile("(?U)(?:\\W\\w|\\w\\W)");
Matcher matcher = pattern.matcher(s);
if (matcher.find()){
    System.out.println(matcher.group() + " word boundary found!"); 
} else {
    System.out.println("Word boundary NOT found in " + s);  
}