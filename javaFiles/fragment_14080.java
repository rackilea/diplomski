String pickedCards = ""
int totalPickedCards = 0
boolean continue = true;
for(continue) 
{
  tempVariable = pickedCard
  if (pickedCard.contains("/"+tempVariable+"/") == false) { // if you didn't already pick it then
    pickedCards = pickedCards + "/" + tempVariable + "/";
    // save the card you picked - stored in tempVariable
    ++totalPickedCards
  }
  if (totalPickedCards >= 3) { // exit loop if you have 3 cards picked
    continue = false;
  }
}