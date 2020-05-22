StringBuilder sb = new StringBuilder();
for(String s: myArray) {
    sb.append(s);
    if(sb.length()>0) {
       sb.append(',');
    }
}
System.println(s.toString());