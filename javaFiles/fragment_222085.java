String english = "hip-hop";
String[] words = english.split("[\\s+]|(?<=-)|(?=-)");
String[] latin = new String[words.length];
String phrase = "";

String previousWord = "";
for (int i = 0; i < words.length; i++) {
   latin[i] = words[i];
   if (words[i].equals("-") || previousWord.equals("-")) {
      phrase = phrase + latin[i];
   } else {
      phrase = phrase + " " + latin[i];
   }
   previousWord = words[i];
}

System.out.println(phrase);