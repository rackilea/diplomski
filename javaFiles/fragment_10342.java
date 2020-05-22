private static HashSet<String> allWords = new HashSet<String>();
private static HashSet<String> diction = new HashSet<String>();

public static void compare() {
  try {
    Scanner file1 = new Scanner(new File("random_letters.txt"));
    Scanner file2 = new Scanner(new File("dictionary.txt"));

    for(int i = 0; i < 2187; i++) {
      allWords.add(file1.next());
    }

    for(int i = 0; i < 79765; i++) {
      diction.add(file2.next().toUpperCase());
    }

    //Compile set of words that are in both
    HashSet<String> intersect = new HashSet<String>();
    intersect.addAll(allWords);
    intersect.retainAll(diction);

    for (String s : intersect){
        System.out.println(s);
    }

    //For every word in random_letters, see if there is a word in diction that is the start of it
    HashSet<String> couplesIntersect = new HashSet<String>();
    for(String s : allWords){
        for(String d : diction){
            if(s.startsWith(d)){
                //If so, check every word in diction again to see if there is a word that is the remainder
                String remainder = s.subString(d.length());
                for(String d2 : diction){
                    if(d2.equals(remainder))
                        //If so, store this word
                        couplesIntersect.add(s);
                }
            }
        }
     }

     //Print those results
     for (String s : couplesIntersect){
         System.out.println(s);
     }

  } catch (IOException e) {
    System.out.println("could not find file");
  } 
 }
}