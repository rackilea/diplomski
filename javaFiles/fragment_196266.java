String s = "XYZ(?,?,?)";
String[] tokens = s.split("\\?");
s = "";
for(int i = 0; i < array.length; i++){
   s += tokens[i] + array[i];
}
s += tokens[array.length];