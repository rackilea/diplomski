String[] split = "padding/test/for/loop/es-es/Replica-2300/saliffanag/winsrow".split("/");
String result = "";  

for(String s : split){
  if(s.length() != 5){ continue;} 
  if(s.charAt(2) == '-'){
    result = s; //if you need the '/' just use result = "/" + s "/";
    break;
  }
}