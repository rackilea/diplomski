public static void main(String[] args) {
     List<Item> items = parseItemInfo(fetchRequiredData(requestUrl));
     System.out.println("Printing List<Item> contents ...");
     for (Item item : items) {
         System.out.println("Title is " + item.getTitle()); 
         System.out.println("Price is " + item.getPrice());
         System.out.println();
     }
}