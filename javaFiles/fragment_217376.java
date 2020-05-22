String veryHugeString = ....;//
String[] words = new String[]{...};
boolean foundAtLeastOne = false;
for (String word : words) {
   if (veryHugeString.indexOf(word) > 0) {
       foundAtLeastOne = true;
       System.out.println("Word: " + word + " is found);
       break;
   }
}

System.out.println("Found at least one : " + foundAtLeastOne);