Pattern p = Pattern.compile(regex); 
Matcher m = p.matcher(input);
List<String> matches = new ArrayList<String>();
while(m.find()){
    matches.add(m.group());
}