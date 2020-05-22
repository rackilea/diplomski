class Record
{
   private String item;
   private String category;
   private int quantity; 
   private String timestamp

   // constructor
   public Record (String item, String category, int quantity, String timestamp)
   {
       this.item = item;
       // assign rest of members...
   }

   public String getCategory ()
   {
       return category;
   }

   // rest of getters and setters for all members...
}