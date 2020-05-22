StringBuilder finalStringBuilder= new StringBuilder("");
for(String s:lines){
   if(!s.equals("")){
       finalStringBuilder.append(s).append(System.getProperty("line.separator"));
    }
}
String finalString = finalStringBuilder.toString();