public static Collection<String> longestCommonSubstrings(String S1, String S2){
  return longestCommonSubstrings(S1, S2, 0);
}

public static Collection<String> longestCommonSubstrings(String S1, String S2, int minimumLength){

Collection<Integer> indexes = new ArrayList<Integer>();
int Max = minimumLength;

for (int i = 0; i < S1.length(); i++){
  for (int j = 0; j < S2.length(); j++){
    int x = 0;
    int y = Math.min(S1.length()-i,S2.length()-j);
    while (x < y && (S1.charAt(i + x) == S2.charAt(j + x) )){
      x++;
    }
    if (x > Max){
      Max = x;
      indexes = new ArrayList<Integer>();
      indexes.add(i);
    }else if (x == Max){
      indexes.add(i);
    }
  }
}
Collection<String> results = new HashSet<String>();
for (Integer i : indexes){
  results.add(S1.substring(i, (i + Max)));
}
return results;
}