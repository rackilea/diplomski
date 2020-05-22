String a = "cats";
String b = "cuts";
String result = "";
if(a.length() != b.length()){
    result = "BYE";
}
else if (a.compareTo(b) <= 0){
    result = "TRUE";
}
else{
    result = "FALSE";
}
System.out.println(result);