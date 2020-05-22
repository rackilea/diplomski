File file=new File("path.log");
String name=file.toString();
String tok[]=name.split("\\.");
if(tok[tok.length-1].equals("log")){
    //compute
}