String commitMessage = "This fixes #23 fixed#24 fix #25, #26 resolves #27 #28#29 resolved#30 #31 ,  #32. Also see #33";
String regex = "(?:(?:clos|resolv)(?:e|es|ed|ing)|fix(?:es|ed|ing)?)(?:[\\s\\p{P}]*#[0-9]+)+";
Pattern p = Pattern.compile(regex);
Matcher m = p.matcher(commitMessage);
while (m.find()){
    System.out.println(m.group(0));
}