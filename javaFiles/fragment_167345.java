String text = "root(ROOT-0, good-4)nn(management-2, company-1)nsubj(good-4, management-2)";
List<String> myPairs = new ArrayList<String>();
Pattern p = Pattern.compile(".+?\\(.+?,.+?\\)");
Matcher m = p.matcher(text);
while (m.find()) {
    myPairs.add(m.group());
}
System.out.println(myPairs);