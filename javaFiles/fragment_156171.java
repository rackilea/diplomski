public static ArrayList<String> doubleWords(ArrayList<String> input) {
  ArrayList<String> result = new ArrayList<>();
  for (String string : input) {
     String word = "";
     for (int i = 0; i < string.length(); i++) {
        word += ""+string.charAt(i)+string.charAt(i);
     }
     result.add(word);
  }
  return result;
}