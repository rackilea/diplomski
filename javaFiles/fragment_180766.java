String s1 = "AB CD #E     F# #GH   I# JK L   M";
StringBuilder sb = new StringBuilder();
boolean keepSpace = false;
for(int i = 0; i < s1.length; i++){
    char c = s1.charAt(i);
    if(keepSpace || c != ' ')
        sb.append(c);
    if(c == '#')
        keepSpace = !keepSpace;
}
s1 = sb.toString();
System.out.println(s1);