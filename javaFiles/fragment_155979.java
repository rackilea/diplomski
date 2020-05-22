String s = "abc";
String result = "";
int i = 0;
while (i < s.length()){
    char c = s.charAt(i);
    result = result + c + c;
    i++;
}