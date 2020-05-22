boolean labelClicked = false;
    private void cardMouseClicked(java.awt.event.MouseEvent evt) {                                  
    // displays backside of each flashcards when label (flashcard) is clicked   
      if(!labelClicked){
      i++;
      card.setText(cardB[i]);
      labelClicked=true;
      }
         else{
        //doNothing
         }
    }