char char1 = '|', char2 = ')';
String str = "a,b,c,d," + char1 + "e,f,g" + char2 + ",h";
String ch1_quoted = Pattern.quote(Character.toString(char1));
String ch2_quoted = Pattern.quote(Character.toString(char2));
List<String> s2 = new ArrayList<>();
Pattern pattern = Pattern.compile(ch1_quoted + "(.*?)" 
                                    + ch2_quoted + "|[^," + ch1_quoted + ch2_quoted + "]+", Pattern.DOTALL);
Matcher matcher = pattern.matcher(str);
while (matcher.find()){
    if (matcher.group(1) != null) {
        s2.add(matcher.group(1));
        System.out.println(matcher.group(1));
    } else {
        s2.add(matcher.group(0)); 
        System.out.println(matcher.group(0));
    }
}