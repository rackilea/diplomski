List<File> files = new ArrayList<File>(Arrays.asList(file.listFiles()));
Iterator<File> iterator = files.iterator();
while(iterator.hasNext()){
    File currentFile = iterator.next();
    if(someCondition){
        iterator.remove();
    }
    // other operations
}