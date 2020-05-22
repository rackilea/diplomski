String s = "ab57cdZZ78efghZZ7ij@klmZZ78noCODpqrZZ78stuvw27z@xyzZZ78";
Pattern regex = Pattern.compile("((?:(?!ZZ78).)*)(ZZ78|$)");
Matcher matcher = regex.matcher(s);
while(matcher.find()){
        System.out.println(matcher.group(1));
}