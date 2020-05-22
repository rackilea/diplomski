enum Item {
   ITEM_1("Item no. 1"),
   ITEM_2("A second item");     

   private final String name;

   private Item( String name ) {
     this.name = name;
   } 

   public String getName() { return name; }
 }

 class CheckList {
   private final int maxItemsAllowed;
   private final Map<Item, Boolean> items; //make this a TreeMap or LinkedHashMap

   //Constructor and other methods omitted for clarity 

   public void check(Item item, boolean checked ) {
     if( !items.containsKey( item ) ) { 
       throw new IllegalArgumentException("unknown item"); 
     }
     items.put(item, checked); //note the autoboxing here
   }

   public double getScore() {
     int countChecked = 0;
     int countTotal = 0;  //see explanation below
     for( Boolean b : items.values() ) {
       if( Boolean.TRUE.equals( b ) {
         countChecked++;
       }
       countTotal++;
     }

     return (double)countChecked/countTotal;
   }
 }