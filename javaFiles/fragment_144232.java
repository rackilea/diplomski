String args = "-app app1 app2 app3 -env ev1 env2";
String[] splitDashes = args.split("-");
List<String> appList = new ArrayList();
List<String> envList = new ArrayList();

for(String split : splitDashes){
    String[] splitSpaces = split.split(" ");
    if (splitSpaces[0].equals("app"))
    {
        for(String s : splitSpaces){
            if(!s.equals("app"))
                appList.add(s);
        }
    }
    else if(splitSpaces[0].equals("env"))
    {
        for(String s : splitSpaces){
            if(!s.equals("env"))
                envList.add(s);
        }
    }
}