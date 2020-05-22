pubic class Category {
   Integer id;
   int catId;
   String catTitle;
   ..........................

   @Override   
   public boolean equals(Object other) {
       return (other instanceOf Category) && equate((Category) other);
   }  

   private boolean equate(Category other) {
       return other != null &&
           catId == other.catId &&  
           equateIds(id, other.id) && 
           equateTitles (catTitle, other.catTitle);
   } 

   // Ids are considered equal, if equal, or at least one is null
   private static bool equateIds(Integer id1, Integer id2) {
      return (id1==null) || (id2==null) ||
            id1.intValue() == id2.intValue(); 
   } 

   // Titles are considered equal, if equal, or both null
   private static bool equateTitles(String title1, Integer title2) {
      return (title1==null) ? (title2 == null) : title1.equals(title2);
   } 

}