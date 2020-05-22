String originalString ="x = 2+4*a*(b+c)^2";
String stringToInsert = "Math.pow((b+c),2)";

int startIndex = originalString.indexOf("(");
int endIndex = originalString.indexOf(")");

String firstPortion = originalString.substring(0,startIndex);
String lastPortion = originalString.substring(endIndex+1);
String finalString = firstPortion + stringToInsert + lastPortion;

System.out.println("finalString : "+finalString);