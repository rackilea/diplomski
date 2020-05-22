Matcher matcher = Pattern.compile("c").matcher("abcde");
System.out.println(matcher.find()?matcher.start():-1);


Matcher matcher2 = Pattern.compile("[^\\d]").matcher("123bed567");
System.out.println(matcher2.find());

Matcher matcher3 = Pattern.compile("\\d").matcher("asdgh");
System.out.println(matcher3.find()?matcher3.group():null);