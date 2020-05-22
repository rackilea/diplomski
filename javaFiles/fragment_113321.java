String name1 = "raja";
String name2 = "rani";
for (int i = 0; i < name1.length(); i++) {
    for (int j = 0; j < name2.length(); j++) {
        if (name1.charAt(i) == name2.charAt(j)) {       
            name1 = name1.replaceFirst(String.valueOf(name1.charAt(i)), "#");
            name2 = name2.replaceFirst(String.valueOf(name2.charAt(j)), "#");
            break;

        }
    }
}
String result = name1 + name2;
result = result.replaceAll("#","");
int resultLength = result.length(); //need to get 4.
System.out.println(result);
System.out.println(resultLength);