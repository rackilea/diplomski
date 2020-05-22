Pattern p = Pattern.compiler("yourPattern");
Matcher m = p.matcher("yourData");
while(m.find()){
    String match = m.group();
    //here we can do something with match... 
}