"(?:" +                       // Match the regular expression below
   "|" +                         // Match either the regular expression below (attempting the next alternative only if this one fails)
      "(?:" +                       // Match the regular expression below
         "ab" +                        // Match the characters “ab” literally
         "(?:" +                       // Match the regular expression below
                                          // Match either the regular expression below (attempting the next alternative only if this one fails)
               "cd" +                        // Match the characters “cd” literally
            "|" +                         // Or match regular expression number 2 below (the entire group fails if this one fails to match)
               "efgjkln" +                   // Match the characters “efgjkln” literally
         ")" +
      ")" +
   "|" +                         // Or match regular expression number 2 below (the entire group fails if this one fails to match)
      "(?:" +                       // Match the regular expression below
         "(?:" +                       // Match the regular expression below
            "e" +                         // Match the character “e” literally
            "f" +                         // Match the character “f” literally
               "?" +                         // Between zero and one times, as many times as possible, giving back as needed (greedy)
            "jkln" +                      // Match the characters “jkln” literally
         ")" +
      ")" +
"){15,}"                      // Between 15 and unlimited times, as many times as possible, giving back as needed (greedy)