String[] addElement(String old[]){
    String arr[] = new String[old.length+1];
    //copy all the elements in old...
    arr[old.length] = "whatever";
    return arr;
}