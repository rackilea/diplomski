String str = myString.split(" ")[0];
str = str.replace("\\","");
String[] arr = str.split("u");
String text = "";
for(int i = 1; i < arr.length; i++){
    int hexVal = Integer.parseInt(arr[i], 16);
    text += (char)hexVal;
}
// Text will now have Hello