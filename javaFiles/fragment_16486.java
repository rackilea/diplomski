Scanner str = new Scanner(System.in);
 String userInput = str.nextLine();
 Map<Character, Integer> occ = new HashMap<>();
 for(char ch : userInput.toCharArray()) {
  if(!occ.containsKey(ch)) {
    occ.put(ch, 0);
  }
  occ.put(ch, occ.get(ch) + 1);
 }