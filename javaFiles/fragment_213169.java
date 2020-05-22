String s = "ZZ78ab57cdZZ78efghZZ7ij@klmZZ78noCODpqrZZ78stuvw27z@xyzZZ78";
Pattern regex = Pattern.compile("((?:(?!ZZ78).)*)(ZZ78|$)");
Matcher matcher = regex.matcher(s);
ArrayList<String> allMatches = new ArrayList<String>();
ArrayList<String> list = new ArrayList<String>();
while(matcher.find()){
    allMatches.add(matcher.group(1));
}
for (String s1 : allMatches)
    if (!s1.equals(""))
        list.add(s1);

System.out.println(list);