Map<String, String> map = new HashMap<>();
String input = "Reference=R1,R2 GroupId=G01 Date=12/02/2017 15:25";
String[] parts = input.split("\\s+(?=[^=]+=)");
for (String part : parts) {
    map.put(part.split("=")[0], part.split("=")[1]);
    System.out.println(part);
}