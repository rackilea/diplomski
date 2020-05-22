String s = " 90:01:23 42:01";
s = s.trim();
String[] sArr = s.split(":|\\s+");
for(String str : sArr) {
    System.out.println(Integer.parseInt(str));
}