private void checkForSelectionExceeding(String currentSelection){
   int matches = 0;

   for(int i=0; i<roles1.length; i++) {
      if(roles1[i].getSelectedItem().equals(currentSelection)) {
         matches++;
      }

      if(matches > 4) {
         roles1[i].setSelectedItem("Not Selected");
         break;
      }
   }
}