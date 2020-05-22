private String unicodeToString(String u) { 

String str = u.split(" ")[0];
str = str.replace("\\","");
String[] arr = str.split("u");
String text = "";
for(int i = 1; i < arr.length; i++){
    int hexVal = Integer.parseInt(arr[i], 16);
    text += (char)hexVal;
}

  return text;
}