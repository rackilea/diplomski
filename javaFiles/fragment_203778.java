Set<String> toDelete = new HashSet<>();
toDelete.add("end");
toDelete.add("something");
toDelete.add("another thing");

if(toDelete.contains(line)){
     writer.println();
}else{
     writer.println(line);
}