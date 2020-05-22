public static void main(String[] args) {
// TODO Auto-generated method stub
String input = "Q1_R1 true Q1_R2 false Q1_R3 false Q1_R4 true Q1_R5 true Q1_R6 true Q1_R7 true";
String[] pairs = input.split("(?<!\\G\\w+)\\s");
System.out.println(Arrays.toString(pairs));
Map<String, Boolean> myMap = new HashMap<>();
String[] kv = null;
for (String string : pairs) {
    kv = string.split(" ");
    myMap.put(kv[0], Boolean.valueOf(kv[1]));
}
System.out.println(myMap);
}