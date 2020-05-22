if(myHashSet.get((char)alpha) != null && myHashSet.get((char)alpha) > mostCommon)  {
                    mostCommonLtr = (char)alpha;
                    mostCommon = myHashSet.get((char)alpha); 
                    /**
                     * this gave me the most common letter
                     */
                } 

                if(myHashSet.get((char)alpha) != null && myHashSet.get((char)alpha) > leastCommont && alpha != mostCommonLtr )  {
                    leastCommonLtr = (char)alpha;
                    leastCommont = myHashSet.get((char)alpha);
                    /**
                     * this was supposed to give me the least common
                     */

            }