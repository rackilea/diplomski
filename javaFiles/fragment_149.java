ArrayList<String> argList = new ArrayList<String>();
argList.add("param1");
argList.add("param2");
argList.add("param2");
String[] args = argList.toArray(new String[argList.size()]);
Runtime.getRuntime().exec("mycommand", args);