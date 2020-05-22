private void search(String searchElement) {
     for (int i = 0; i < list.size(); i++) {
         String listElement = list.get(i);
         if (searchElement.equals(listElement)) {
             System.out.println("Found element " + searchElement + " at position " + i);
             return;
         }
     }
     System.out.println(searchElement + " does not appear in the list");
}