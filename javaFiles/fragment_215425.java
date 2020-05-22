public static String randomString(int lenOfString){
  String s = "abcdefghijklmnopqrstuvwxyz";
  String randString= "";
  if (lenOfString<=26){
     List<Integer> indexRef = new ArrayList<Integer>();
     for(int i=0; i<s.length(); i++){
            indexRef.add(i);
     }
     Random rnd = new Random();
     for (int i=0; i<lenOfString; i++){
         int index = indexRef.get(rnd.nextInt(indexRef.size()));
         randString+= s.charAt(index);
         indexRef.remove(indexRef.indexOf(index));
     }
  }
  return randString;
}