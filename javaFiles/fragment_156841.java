EventosBean ev=new EventosBean();
ArrayList<String[]> arrayList=ev.listar();
out.println(arrayList.size());
for(String[] strArray : arrayList){
    String str="";
    for(String str1: strArray)
      str=str+" "+str1;

    out.println(str);
}