File lists[] = file.listFiles();
String names[] = new String[lists.length];
if(lists.length > 0){
    for(int i = 0; i < lists.length; i ++){
        names[i] = lists[i].getName();
    }
}else{
    names[0] = "Create New List";
}