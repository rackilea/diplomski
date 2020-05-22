String str = "hello I am a example example"
String[] parts = str.split(" ");
parts[parts.length-1] = "moon";
System.out.println(parts[parts.length-1]); 
StringBuilder sb = new StringBuilder();
for (int i=0; i<parts.length; i++) {
   sb.append(parts[i]);
   sb.append(" ");
}
str = sb.toString();