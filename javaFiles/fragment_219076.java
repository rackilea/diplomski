boolean notEqual = true;           
 for(int i = 0; i<words.length; i++)
     {
         for(int j = 0; j<list.length && notEqual; j++)
         {
                 if(words[i].equals(list[j]))     // If the word of file one exist
                 {                                // file two we set notEqual to false
                      notEqual = false;           // and we terminate the inner cycle
                 }
         }
         if(notEqual)                      // If the notEqual remained  true
           System.out.println(words[i]);   // we print the the element of file one
                                           // that do not exist in the second file

         notEqual = true;                  // set variable to true to be used check
     }                                     // the other words of file one.