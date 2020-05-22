HashSet<String> alreadyHandled = new HasSet<String>();
for(String line:flights){
    String[] parts = line.split(",");
    String lastPart = parts[parts.length-1]
    if(!alreadyHandled.contains(lastPart)){
        alreadyHandled.add(lastPart);

        //Here you have your code what you want to do with your line
    }
}