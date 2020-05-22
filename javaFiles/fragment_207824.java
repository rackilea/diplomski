//global variable 
int flippedCardCounter = 0;
Array[] flippedCards = new Array[2];

gridview.setOnItemClickListener(new OnItemClickListener()
    {
        public void onItemClick(AdapterView<?> parent, View v, int position, long id)
         {   
              switch(flippedCardCounter)

              //flippedCardCounter = 0 -> no cards flipped
              case 0:
                  flippeCardCounter++;    //increase counter
                  flippedCard[0] = position //save reference
                  startFlipAnimation(yourItemAtPosition(0));
                  break;
              //flippedCardCounter = 1 -> one card flipped
              case 1:
                  flippeCardCounter++;    //increase counter
                  flippedCard[1] = position //save reference
                  startFlipAnimation(yourItemAtPosition(1));
                  break;
              //flippedCardCounter = 2 -> hide two flipped card, flip one card
              case 2:
                  flippeCardCounter = 0;    //reset counter

                  //get reference to already flipped card and hide it
                  startUnFlipAnimation(yourItemAtPosition(flippedCards[0]));
                  startUnFlipAnimation(yourItemAtPosition(flippedCards[1]));

                  //reset your array ()
                  flippedCards = new Array[2]; //not really needed
                  flippedCards[0] = position
                  flippeCardCounter++;   //increase counter
                   startFlipAnimation(yourItemAtPosition(position));
                  break;
         }

    });