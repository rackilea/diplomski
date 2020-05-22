Pattern p = Pattern.compile(regex);
Matcher m = p.matcher(yourData);
while(m.find()){
   m.group();//this will return current match in each iteration
   //you can also use other groups here using their indexes
   m.group(2);
   //or names (?<groupName>...)
   m.group("groupName");
}