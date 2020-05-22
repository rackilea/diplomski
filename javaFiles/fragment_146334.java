public static void main(String args[]){
Map commandMap<String,Command> = new HashMap<String,Command>();
commandMap.put("Copy", new Copy());
commandMap.put("Paste", new Paste());
commandMap.put("Delete", new Delete());

if ( commandMap.containsKey(args[0]) ){
commandMap.get(args[0]).exec();

}
}