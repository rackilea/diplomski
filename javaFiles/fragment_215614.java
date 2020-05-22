File file=new File("C:/Temp/");
String name,tok[];
for(File temp:file.listFiles()){
    name=temp.toString();
    tok=name.split("\\.");
    if(tok[tok.length-1].equals("log")){
        //compute
    }
}