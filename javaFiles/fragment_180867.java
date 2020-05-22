class Card {
         private String value;
         private Integer rank;


        ...

         public int compareTo(Card c) {
          // Additional logic if you need to consider 
// also value (suite) in comparison
          return this.rank.compareTo(c.rank);
        }
       }