public static String[] printPigLatinWords() 
{
   for (int i = 0; i < words.length; i++) {
       char firstLetter = words[i].charAt(0);
       words[i] = words[i].substring(1);
       words[i] = words[i] + firstLetter + "ay";
       System.out.println(words[i]);
       //If you want the words to be in the same line, then this could help instead of System.out.println:
       //System.out.print(words[i] + " ");
   }
   return words;

}