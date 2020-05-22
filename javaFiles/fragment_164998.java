File dir = new File("directoryName");
File temp;
String[] children = dir.list();
if (children !=null) {
    for (int i=0; i<children.length; i++) {
        temp = new File(children[i]);
        if(temp.isDirectory()) //add children[i] to arrayList
    }
}