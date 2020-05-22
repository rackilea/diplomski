String[] dalek = new String[]{"Apple","Lenovo"};
String[] replaced = new String[dalek.length];
for (int i = 0; i < dalek.length; i++) {
    // assigning repalced[i] 
    //            | with dalek at index i
    //            |                      | case insensitive    
    //            |                      |   | vowels class (add "y" if necessary)
    //            |                      |   |         | with URL-encoded space
    replaced[i] = dalek[i].replaceAll("(?i)[aeiou]", "%20");
}
System.out.println(Arrays.toString(replaced));