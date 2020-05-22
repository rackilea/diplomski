StringBuilder b = new StringBuilder();

   // check through letter in each word
   Set<Character>st = new HashSet<>();
   for (int i = 0; i < wordLength; i++) {

       st.clear();
       char[] charArray = new char[wordLength];
       // checks each word in the array

       for (int j = 0; j < 4; j++) {
           char ch = array[j].charAt(i);
           if(st.add(ch))  
           b.append(ch);
       }
   }